package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.desktopclient.cache.Cache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.AuthorizationService;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.ClientService;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.DialogView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.LoginWindowView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowAdminView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.*;

/**
 * @author ilya-murzinov
 */
@Component
public class LoginWindowController {
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private MainWindowUserView mainWindowUserView;

    @Autowired
    private MainWindowAdminView mainWindowAdminView;

    @Autowired
    private LoginWindowView loginWindowView;

    @Autowired
    private Cache cache;

    @PostConstruct
    public void init() {
        KeyListener enterListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        };
        loginWindowView.getPasswordTextField().addKeyListener(enterListener);
        loginWindowView.getLoginButton().addKeyListener(enterListener);

        loginWindowView.getLoginButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login();
            }
        });
    }

    public void login() {
        String login = loginWindowView.getLoginTextField().getText();
        String password = loginWindowView.getPasswordTextField().getText();

        if (login.equals("") || password.equals("")) {
            new DialogView(
                    loginWindowView.getFrame(),
                    "Login error",
                    "Please fill username and password"
            ).display();
            return;
        }

        authorizationService.login(login, password);

        if (authorizationService.isAuthorized()) {
            loginWindowView.close();
            if (authorizationService.isUser()) {
                int clientId = authorizationService.getUser().getClientId();
                cache.setClient(clientService.getClient(clientId));
                mainWindowUserView.show();
            } else {
                mainWindowAdminView.show();
            }
        } else {
            new DialogView(
                    loginWindowView.getFrame(),
                    "Login error",
                    "Wrong username or password"
            ).display();
        }
    }
}
