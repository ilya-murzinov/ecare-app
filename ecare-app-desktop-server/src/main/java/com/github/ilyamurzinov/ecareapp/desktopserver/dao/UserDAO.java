package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.User;

import javax.persistence.EntityManager;

/**
 * @author ilya-murzinov
 */
public interface UserDAO {
    User getUser(EntityManager entityManager, String login);
    void updateUser(EntityManager entityManager, User user);
}
