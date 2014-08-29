package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ilya-murzinov
 */
public class SecurityHelper {
    private SecurityHelper() {}

    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
