package com.github.ilyamurzinov.ecareapp.web.service;

/**
 * @author ilya-murzinov
 */
public interface UserService {
    boolean changePassword(int id, String currentPassword, String newPassword);
}
