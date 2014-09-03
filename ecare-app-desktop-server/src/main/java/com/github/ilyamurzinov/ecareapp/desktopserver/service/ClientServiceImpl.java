package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.desktopserver.dao.ClientDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Service
public class ClientServiceImpl extends AbstractService implements ClientService {

    private Logger logger = LogManager.getLogger(ClientService.class);

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client getClient(int id) {
        Client client;
        try {
            createEntityManager();
            client = clientDAO.getClient(entityManager, id);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
        logger.debug("getClient {}", client);
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients;
        try {
            createEntityManager();
            clients = clientDAO.getAllClients(entityManager);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return clients;
    }

    @Override
    public void addClient(Client client) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            clientDAO.addClient(entityManager, client);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateClient(Client client) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            clientDAO.updateClient(entityManager, client);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void removeClient(int id) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            clientDAO.removeClient(entityManager, id);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
