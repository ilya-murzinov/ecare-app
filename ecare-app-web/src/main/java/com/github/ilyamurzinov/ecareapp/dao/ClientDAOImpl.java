package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class ClientDAOImpl implements ClientDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Client getClient(int id) {
        Query query = entityManager.createQuery("select c from Client c where c.id = :id")
                .setParameter("id", id);
        return (Client) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getAllClients() {
        Query query = entityManager.createQuery("select c from Client c");
        return (List<Client>) query.getResultList();
    }

    @Override
    public void addClient(Client client) {
        entityManager.persist(client);
    }

    @Override
    public void removeClient(int id) {
        entityManager.remove(getClient(id));
    }

    @Override
    public void updateClient(Client client) {
        entityManager.merge(client);
    }
}
