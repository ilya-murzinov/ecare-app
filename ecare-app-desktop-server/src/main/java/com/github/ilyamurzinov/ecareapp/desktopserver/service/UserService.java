package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.common.domain.User;

/**
 * @author ilya-murzinov
 */
public interface UserService {
    User getUser(String login);
    void updateUser(User user);
}
