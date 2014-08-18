package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.desktopclient.service.AuthorizationService;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.LoginWindowView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowAdminView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ilya-murzinov
 */
@Component
public class MainController {
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private MainWindowUserView mainWindowUserView;

    @Autowired
    private MainWindowAdminView mainWindowAdminView;

    @Autowired
    private LoginWindowView loginWindowView;

    public void run() {
        if (authorizationService.isAuthorized()) {
            if (authorizationService.isUser()) {
                mainWindowUserView.show();
            } else {
                mainWindowAdminView.show();
            }
        } else {
            loginWindowView.show();
        }
    }
}
