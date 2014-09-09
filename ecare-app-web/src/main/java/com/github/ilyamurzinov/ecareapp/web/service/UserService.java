package com.github.ilyamurzinov.ecareapp.web.service;

/**
 * @author ilya-murzinov
 */
public interface UserService {
    void changePassword(int id, String currentPassword, String newPassword);

    void addClient(String email, String password, int clientId);
}
