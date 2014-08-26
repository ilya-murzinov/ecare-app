package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;

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
