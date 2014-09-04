package com.github.ilyamurzinov.ecareapp.web.service;

/**
 * @author ilya-murzinov
 */
public interface UserService {
    void changePassword(int id, String currentPassword, String newPassword);
    String addClient(String email, String password, int clientId);
}
