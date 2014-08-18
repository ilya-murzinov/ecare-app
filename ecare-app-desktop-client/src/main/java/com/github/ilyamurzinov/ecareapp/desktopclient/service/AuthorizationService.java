package com.github.ilyamurzinov.ecareapp.desktopclient.service;

/**
 * @author ilya-murzinov
 */
public interface AuthorizationService {
    boolean isAuthorized();
    boolean isUser();
    void login(String login, String password);
}
