package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.User;

/**
 * @author ilya-murzinov
 */
public interface UserDAO {
    User getUser(String login);
    void updateUser(User user);
}
