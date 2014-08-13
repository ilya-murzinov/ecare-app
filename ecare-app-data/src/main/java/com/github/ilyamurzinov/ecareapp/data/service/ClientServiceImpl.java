package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.ClientDAO;
import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LogManager.getRootLogger();

    @Autowired
    private ClientDAO clientDAO;

    @Override
    @Transactional
    public Client getClient(int id) {
        Client client = clientDAO.getClient(id);
        logger.info(client);
        return client;
    }

    @Override
    @Transactional
    public List getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    @Transactional
    public void addClient(Client client) {
        clientDAO.addClient(client);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        clientDAO.removeClient(id);
    }
}
