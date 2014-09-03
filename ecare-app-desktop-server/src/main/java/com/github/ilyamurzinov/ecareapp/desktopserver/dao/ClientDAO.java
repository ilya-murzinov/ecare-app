package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface ClientDAO {

    Client getClient(EntityManager entityManager, int id);

    List<Client> getAllClients(EntityManager entityManager);

    void addClient(EntityManager entityManager, Client client);

    void removeClient(EntityManager entityManager, int id);

    void updateClient(EntityManager entityManager, Client client);
}
