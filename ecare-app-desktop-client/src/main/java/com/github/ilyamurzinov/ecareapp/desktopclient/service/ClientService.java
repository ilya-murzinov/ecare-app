package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface ClientService {
    Client getClient(int id);

    List<Client> getAllClients();

    void addClient(Client client);

    void updateClient(Client client);

    void removeClient(Client client);
}
