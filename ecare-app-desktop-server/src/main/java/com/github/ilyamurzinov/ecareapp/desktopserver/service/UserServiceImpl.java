package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.desktopserver.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            createEntityManager();
            return userDAO.getUser(entityManager, login);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateUser(User user) {

    }
}
