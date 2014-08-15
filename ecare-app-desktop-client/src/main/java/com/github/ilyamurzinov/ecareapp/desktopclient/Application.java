package com.github.ilyamurzinov.ecareapp.desktopclient;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.desktopclient.connection.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author ilya-murzinov
 */
public class Application {
    private static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        logger.info("Client started");
        Connection connection = new Connection();
        Client client = connection.getClient(1);
        logger.info(client);
    }
}
