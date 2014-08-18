package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface ClientDAO extends DAO {

    Client getClient(int id);

    List<Client> getAllClients();

    void addClient(Client client);

    void removeClient(int id);

    void updateClient(Client client);
}
