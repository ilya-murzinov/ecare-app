package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.data.domain.User;

/**
 * @author ilya-murzinov
 */
public interface AuthorizationService {
    boolean isAuthorized();

    boolean isUser();

    void login(String login, String password);

    User getUser();
}
