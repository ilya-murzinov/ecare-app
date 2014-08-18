package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.domain.User;

/**
 * @author ilya-murzinov
 */
public interface UserService {
    User getUser(String login);
}
