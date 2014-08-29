package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ilya-murzinov
 */
public class SecurityHelper {
    private SecurityHelper() {}

    public static User getCurrentUser() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user instanceof User) {
            return (User) user;
        }
        throw new IllegalStateException("You are not logged in");
    }
}
