package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class ClientDAOImpl implements ClientDAO {
    @Override
    public Client getClient(EntityManager entityManager, int id) {
        Query query = entityManager.createQuery("select c from Client c where c.id = :id").setParameter("id", id);
        return (Client) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getAllClients(EntityManager entityManager) {
        Query query = entityManager.createQuery("select c from Client c");
        return query.getResultList();
    }

    @Override
    public void addClient(EntityManager entityManager, Client client) {
        entityManager.persist(client);
    }

    @Override
    public void removeClient(EntityManager entityManager, int id) {
        Client client = getClient(entityManager, id);
        if (client != null) {
            entityManager.remove(client);
        }
    }

    @Override
    public void updateClient(EntityManager entityManager, Client client) {
        entityManager.merge(client);
    }
}
