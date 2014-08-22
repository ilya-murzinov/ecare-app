package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.ClientDAO;
import com.github.ilyamurzinov.ecareapp.data.dao.DAO;
import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            createAndInjectEntityManager();
            client = clientDAO.getClient(id);
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
            createAndInjectEntityManager();
            clients = clientDAO.getAllClients();
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
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            clientDAO.addClient(client);
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
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            clientDAO.updateClient(client);
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
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            clientDAO.removeClient(id);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    protected void setDAOs() {
        daos = new ArrayList<DAO>() {
            {add(clientDAO);}
        };
    }
}
