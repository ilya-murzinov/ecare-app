package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.web.dao.ClientDAO;
import com.github.ilyamurzinov.ecareapp.web.dao.UserDAO;
import com.github.ilyamurzinov.ecareapp.web.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private UserDAO userDAO;

    @Override
    public Client getCurrentClient() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getClient();
    }

    @Override
    public Client getClient(int id) {
        return clientDAO.getClient(id);
    }
}
