package com.github.ilyamurzinov.ecareapp.serverdesktop;

import com.github.ilyamurzinov.ecareapp.data.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ilya-murzinov
 */
@Component
public class Server {
    private Logger logger = LogManager.getLogger(Server.class);

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

        public RequestHandler(Socket socket) throws IOException {
            this.socket = socket;
            inputStream = this.socket.getInputStream();
            outputStream = this.socket.getOutputStream();
        }

        @Override
        public void run() {
            try {
                writeResponse(clientService.getClient(1).toString());
            } catch (IOException e) {
                Server.this.logger.error(e);
            }
        }

        private void writeResponse(String s) throws IOException {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Server: YarServer/2009-09-09\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + s.length() + "\r\n" +
                    "Connection: close\r\n\r\n";
            String result = response + s;
            outputStream.write(result.getBytes());
            outputStream.flush();
        }
    }
}
