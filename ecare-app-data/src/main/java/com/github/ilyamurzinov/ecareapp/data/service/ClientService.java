package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface ClientService {
    Client getClient(int id);

    List<Client> getAllClients();

    void addClient(Client client);

    void removeClient(int id);
}
