package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.Client;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface ClientDAO {

    Client getClient(int id);

    List<Client> getAllClients();

    void addClient(Client client);

    void removeClient(int id);

    void updateClient(Client client);
}
