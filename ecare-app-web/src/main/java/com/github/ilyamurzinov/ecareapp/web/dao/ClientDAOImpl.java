package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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
