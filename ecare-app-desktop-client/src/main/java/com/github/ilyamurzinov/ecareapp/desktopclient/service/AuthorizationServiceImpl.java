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

    private boolean authorized;

    @Override
    public boolean isAuthorized() {
        return authorized;
    }

    @Override
    public boolean isUser() {
        return true;
    }

    @Override
    public boolean login(String login, String password) {
        try {
            User request = new User();
            request.setLogin(login);
            request.setPassword(password);

            helper.getObjectOutputStream().writeObject(request);
            User response = (User) helper.getObjectInputStream().readObject();

            authorized = response != null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return authorized;
    }
}
