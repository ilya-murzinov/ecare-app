package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class ClientDAOImpl implements ClientDAO {

    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Client getClient(int id) {
        Query query = entityManager.createQuery("from Client c where c.id = :id").setParameter("id", id);
        return (Client) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getAllClients() {
        Query query = entityManager.createQuery("from Client c");
        return query.getResultList();
    }

    @Override
    public void addClient(Client client) {
        entityManager.persist(client);
    }

    @Override
    public void removeClient(int id) {
        Client client = getClient(id);
        if (client != null) {
            entityManager.remove(client);
        }
    }
}
