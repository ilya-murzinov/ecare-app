package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author ilya-murzinov
 */
@Component
public class ConnectionHelper {
    private Logger logger = LogManager.getLogger(ConnectionHelper.class);

    public static final String HOST = "localhost";
    public static final int PORT = 8080;

    public static final String GET = "GET";

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ConnectionHelper() {
        try {
            Socket socket = new Socket(HOST, PORT);
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }
}
