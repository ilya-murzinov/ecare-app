package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface ClientService {
    Client getClient(int id);

    List<Client> getAllClients();

    void addClient(Client client);

    void updateClient(Client client);

    void removeClient(int id);
}
