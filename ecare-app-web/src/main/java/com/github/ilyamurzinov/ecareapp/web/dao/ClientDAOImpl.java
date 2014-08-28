package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Client getClient(int id) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public void addClient(Client client) {

    }

    @Override
    public void removeClient(int id) {

    }

    @Override
    public void updateClient(Client client) {

    }
}
