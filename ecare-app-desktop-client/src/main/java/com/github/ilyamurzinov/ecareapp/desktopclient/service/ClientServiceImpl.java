package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Component
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ConnectionHelper helper;

    @Override
    public Client getClient(int id) {
        Client c = new Client();
        c.setId(id);
        helper.sendRequest("GET", c);
        return (Client) helper.readObject();
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public void addClient(Client client) {

    }

    @Override
    public void updateClient(Client client) {
        helper.sendRequest("POST", client);
    }

    @Override
    public void removeClient(int id) {
    }
}
