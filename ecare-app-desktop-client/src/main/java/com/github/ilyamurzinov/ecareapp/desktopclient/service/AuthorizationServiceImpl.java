package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author ilya-murzinov
 */
@Component
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private ConnectionHelper helper;

    private User user;

    @Override
    public boolean isAuthorized() {
        return user != null;
    }

    @Override
    public boolean isUser() {
        return user.getClient() != null;
    }

    @Override
    public void login(String login, String password) {
        User request = new User();
        request.setLogin(login);
        request.setPassword(password);

        helper.sendRequest("GET", request);

        user = (User) helper.readObject();
    }

    @Override
    public User getUser() {
        return user;
    }
}
