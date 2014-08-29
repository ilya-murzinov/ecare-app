package com.github.ilyamurzinov.ecareapp.desktopserver;

import com.github.ilyamurzinov.ecareapp.common.Util;
import com.github.ilyamurzinov.ecareapp.common.domain.*;
import com.github.ilyamurzinov.ecareapp.desktopserver.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.RollbackException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.NoSuchAlgorithmException;

/**
 * @author ilya-murzinov
 */
@Component
public class Server {
    private static Logger logger = LogManager.getLogger(Server.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

    public static void main(String[] args) throws InterruptedException, IOException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("server-desktop-spring-сontext.xml");
        Server server = (Server) applicationContext.getBean("server");
        server.start();
    }

    private void start() throws InterruptedException, IOException {
        logger.info("Server started");
        ServerSocket serverSocket = new ServerSocket(4242);
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

                while (true) {
                    String method = (String) objectInputStream.readObject();

                    Object object = objectInputStream.readObject();

                    processRequest(method, object);
                }
            } catch (RollbackException e) {
                try {
                    objectOutputStream.writeObject(null);
                } catch (IOException e1) {
                    logger.error(e, e);
                }
            } catch (IOException e) {
                if (e instanceof SocketException) {
                    logger.info("Client disconnected");
                } else {
                    logger.error(e, e);
                }
            } catch (ClassNotFoundException e) {
                logger.error(e, e);
            } catch (NoSuchAlgorithmException e) {
                logger.error(e, e);
            }
        }

        private void processRequest(String method, Object object) throws IOException, NoSuchAlgorithmException {
            if (method.equals("GET")) {
                if (object instanceof User) {
                    User user = userService.getUser(((User) object).getEmail());
                    if (user != null && Util.getMd5Hash(((User) object).getPassword()).equals(user.getPassword())) {
                        objectOutputStream.writeObject(user);
                    } else {
                        objectOutputStream.writeObject(null);
                    }
                } else if (object instanceof Client) {
                    objectOutputStream.writeObject(
                            clientService.getClient(((Client) object).getId())
                    );
                } else if (object instanceof Tariff) {
                    objectOutputStream.writeObject(
                            tariffService.getTariff(((Tariff) object).getId())
                    );
                }
            } if (method.equals("GET_ALL")) {
                if (object instanceof Client) {
                    objectOutputStream.writeObject(
                            clientService.getAllClients()
                    );
                } else if (object instanceof Tariff) {
                    objectOutputStream.writeObject(
                            tariffService.getAllTariffs()
                    );
                } else if (object instanceof Option) {
                    objectOutputStream.writeObject(
                            optionService.getAllOptions()
                    );
                }
            } else if (method.equals("POST")) {
                if (object instanceof User) {
                    userService.updateUser((User) object);
                } else if (object instanceof Client) {
                    clientService.updateClient((Client) object);
                } else if (object instanceof Contract) {
                    contractService.updateContract((Contract) object);
                } else if (object instanceof Tariff) {
                    tariffService.updateTariff((Tariff) object);
                } else if (object instanceof Option) {
                    optionService.updateOption((Option) object);
                }
            } else if (method.equals("PUT")) {
                if (object instanceof Client) {
                    clientService.addClient((Client) object);
                } else if (object instanceof Contract) {
                    contractService.addContract((Contract) object);
                } else if (object instanceof Tariff) {
                    tariffService.addTariff((Tariff) object);
                } else if (object instanceof Option) {
                    optionService.addOption((Option) object);
                }
            } else if (method.equals("DELETE")) {
                if (object instanceof Client) {
                    clientService.removeClient(((Client) object).getId());
                } else if (object instanceof Contract) {
                    contractService.removeContract(((Contract) object).getId());
                } else if (object instanceof Tariff) {
                    tariffService.removeTariff(((Tariff) object).getId());
                } else if (object instanceof Option) {
                    optionService.removeOption(((Option) object).getId());
                }
            }
        }
    }
}
