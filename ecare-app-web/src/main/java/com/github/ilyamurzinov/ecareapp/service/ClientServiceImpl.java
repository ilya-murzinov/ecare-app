package com.github.ilyamurzinov.ecareapp.service;

import com.github.ilyamurzinov.ecareapp.domain.Client;
import com.github.ilyamurzinov.ecareapp.beans.UserBean;
import com.github.ilyamurzinov.ecareapp.controller.SecurityHelper;
import com.github.ilyamurzinov.ecareapp.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private SecurityHelper securityHelper;

    @Override
    public Client getCurrentClient() {
        UserBean user = securityHelper.getCurrentUser();
        return clientDAO.getClient(user.getClient().getId());
    }

    @Override
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    public Client getClient(int id) {
        return clientDAO.getClient(id);
    }

    @Override
    public void updateClient(Client client) {
        clientDAO.updateClient(client);
    }

    @Override
    public void addClient(Client client) {
        clientDAO.addClient(client);
    }

    @Override
    public void removeClient(int id) {
        clientDAO.removeClient(id);
    }
}
