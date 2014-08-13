package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getAllClients() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Client").list();
    }

    @Override
    public void addClient(Client client) {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public void removeClient(int id) {
        Client client = getClient(id);
        if (client != null) {
            sessionFactory.getCurrentSession().delete(client);
        }
    }
}
