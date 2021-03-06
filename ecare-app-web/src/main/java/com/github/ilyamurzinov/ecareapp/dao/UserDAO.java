package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.User;

/**
 * @author ilya-murzinov
 */
public interface UserDAO {
    User getUser(int id);

    User getUser(String login);

    void updateUser(User user);

    void addUser(User user);
}
