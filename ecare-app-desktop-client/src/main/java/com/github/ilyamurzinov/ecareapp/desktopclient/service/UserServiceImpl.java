package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ilya-murzinov
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private ConnectionHelper connectionHelper;

    @Override
    public void updateUser(User user) {
        connectionHelper.sendRequest("POST", user);
    }
}
