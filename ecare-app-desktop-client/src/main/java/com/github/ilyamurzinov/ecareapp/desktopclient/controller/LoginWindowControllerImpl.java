package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.desktopclient.service.AuthorizationService;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.LoginErrorDialogView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.LoginWindowView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowAdminView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * @author ilya-murzinov
 */
@Component
public class LoginWindowControllerImpl implements LoginWindowController {
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private MainWindowUserView mainWindowUserView;

    @Autowired
    private MainWindowAdminView mainWindowAdminView;

    @Autowired
    private LoginWindowView loginWindowView;

    public void login() {
        String login = loginWindowView.getLoginTextField().getText();
        String password = loginWindowView.getPasswordTextField().getText();
        if (authorizationService.login(login, password)) {
            loginWindowView.close();
            if (authorizationService.isUser()) {
                mainWindowUserView.show();
            } else {
                mainWindowAdminView.show();
            }
        } else {
            new LoginErrorDialogView(
                   loginWindowView.getFrame(),
                   "Login error",
                   "Wrong username or password"
            ).display();
        }
    }
}
