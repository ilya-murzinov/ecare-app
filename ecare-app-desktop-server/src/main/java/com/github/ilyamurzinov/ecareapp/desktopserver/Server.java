package com.github.ilyamurzinov.ecareapp.desktopserver;

import com.github.ilyamurzinov.ecareapp.data.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ilya-murzinov
 */
@Component
public class Server {
    private static Logger logger = LogManager.getLogger(Server.class);

    @Autowired
    private ClientService clientService;

    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("server-desktop-spring-сontext.xml");
        Server server = (Server) applicationContext.getBean("server");
        server.start();
    }

    private void start() throws InterruptedException, IOException {
        logger.info("Server started");
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            logger.info("Client accepted");
            new Thread(new RequestHandler(socket)).start();
        }
    }

    private class RequestHandler implements Runnable {
        private Socket socket;
        private InputStream inputStream;
        private OutputStream outputStream;
        private ObjectInputStream objectInputStream;
        private ObjectOutputStream objectOutputStream;

        public RequestHandler(Socket socket) throws IOException {
            this.socket = socket;
            inputStream = this.socket.getInputStream();
            outputStream = this.socket.getOutputStream();
        }

        @Override
        public void run() {
            try {
                objectOutputStream = new ObjectOutputStream(outputStream);
                objectInputStream = new ObjectInputStream(inputStream);
                String request = (String) objectInputStream.readObject();
                objectOutputStream.writeObject(
                        clientService.getClient(Integer.parseInt(request.substring(request.indexOf(' ') + 1)))
                );
                objectOutputStream.flush();
            } catch (IOException e) {
                logger.error(e, e);
            } catch (ClassNotFoundException e) {
                logger.error(e);
            }
        }
    }
}
