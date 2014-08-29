package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.web.controller.SecurityHelper;
import com.github.ilyamurzinov.ecareapp.web.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client getCurrentClient() {
        User user = SecurityHelper.getCurrentUser();
        return user.getClient();
    }

    @Override
    public Client getClient(int id) {
        return clientDAO.getClient(id);
    }
}
