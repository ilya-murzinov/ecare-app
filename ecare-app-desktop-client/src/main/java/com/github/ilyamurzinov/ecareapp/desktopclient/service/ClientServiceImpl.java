package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
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

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> getAllClients() {
        Client c = new Client();
        helper.sendRequest("GET_ALL", c);
        return (List<Client>) helper.readObject();
    }

    @Override
    public void addClient(Client client) {
        helper.sendRequest("PUT", client);
    }

    @Override
    public void updateClient(Client client) {
        helper.sendRequest("POST", client);
    }

    @Override
    public void removeClient(Client client) {
        helper.sendRequest("DELETE", client);
    }
}
