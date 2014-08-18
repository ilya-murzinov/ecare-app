package com.github.ilyamurzinov.ecareapp.desktopclient.service;

/**
 * @author ilya-murzinov
 */
public interface AuthorizationService {
    boolean isAuthorized();
    boolean isUser();
    boolean login(String login, String password);
}
