package com.github.ilyamurzinov.ecareapp.service;

import com.github.ilyamurzinov.ecareapp.domain.User;

/**
 * @author ilya-murzinov
 */
public interface UserService {
    void changePassword(int id, String currentPassword, String newPassword);

    void addClient(String email, String password, int clientId);

    void updateUser(User user);
}
