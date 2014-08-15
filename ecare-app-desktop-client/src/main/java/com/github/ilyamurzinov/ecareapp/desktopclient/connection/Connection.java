package com.github.ilyamurzinov.ecareapp.desktopclient.connection;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author ilya-murzinov
 */
public class Connection {
    private Logger logger = LogManager.getLogger(Connection.class);

    public static final String HOST = "localhost";
    public static final int PORT = 8080;

    public static final String GET = "GET";

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public Connection() {
        try {
            Socket socket = new Socket(HOST, PORT);
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public Client getClient(int id) {
        try {
            objectOutputStream.writeObject(GET + " " + 1);
            return (Client) objectInputStream.readObject();
        } catch (IOException e) {
            logger.error(e);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        return null;
    }
}
