package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.DAO;
import com.github.ilyamurzinov.ecareapp.data.dao.UserDAO;
import com.github.ilyamurzinov.ecareapp.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author ilya-murzinov
 */
@Service
public class UserServiceImpl extends AbstractService implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    public User getUser(String login) {
        try {
            createAndInjectEntityManager();
            return userDAO.getUser(login);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }


    @Override
    protected void setDAOs() {
        daos = new ArrayList<DAO>() {{
            add(userDAO);
        }};
    }
}
