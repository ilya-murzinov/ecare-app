package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface ClientDAO {
    Client getClient(int id);

    List getAllClients();

    void addClient(Client client);

    void removeClient(int id);
}
