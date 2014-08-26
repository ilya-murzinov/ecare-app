package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.User;

/**
 * @author ilya-murzinov
 */
public interface UserDAO extends DAO {
    User getUser(String login);
    void updateUser(User user);
}
