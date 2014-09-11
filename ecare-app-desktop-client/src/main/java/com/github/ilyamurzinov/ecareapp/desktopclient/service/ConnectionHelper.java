package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
    public static final int PORT = 4242;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ConnectionHelper() {
        try {
            Socket socket = new Socket(HOST, PORT);
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            objectInputStream = null;
            objectOutputStream = null;
            logger.error(e);
        }
    }

    private ObjectInputStream getObjectInputStream() {
        if (objectInputStream == null) {
            try {
                Socket socket = new Socket(HOST, PORT);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                objectInputStream = null;
                objectOutputStream = null;
                logger.error(e);
            }
        }
        return objectInputStream;
    }

    private ObjectOutputStream getObjectOutputStream() {
        if (objectOutputStream == null) {
            try {
                Socket socket = new Socket(HOST, PORT);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                objectInputStream = null;
                objectOutputStream = null;
                logger.error(e);
            }
        }
        return objectOutputStream;
    }

    private void writeObject(Object o) {
        try {
            getObjectOutputStream().writeObject(o);
        } catch (IOException e) {
            logger.error(e, e);
        }
    }

    public Object readObject() {
        try {
            return getObjectInputStream().readObject();
        } catch (IOException e) {
            logger.error(e, e);
        } catch (ClassNotFoundException e) {
            logger.error(e, e);
        }
        return null;
    }

    public void sendRequest(String method, Object object) {
        writeObject(method);
        writeObject(object);
    }
}
