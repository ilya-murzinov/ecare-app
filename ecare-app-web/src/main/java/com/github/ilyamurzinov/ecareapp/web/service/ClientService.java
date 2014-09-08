package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface ClientService {
    Client getCurrentClient();

    List<Client> getAllClients();

    Client getClient(int id);

    void updateClient(Client client);

    void addClient(Client client);

    void removeClient(int id);
}
