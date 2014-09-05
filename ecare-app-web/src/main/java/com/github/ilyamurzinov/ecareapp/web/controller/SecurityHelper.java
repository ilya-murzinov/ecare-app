package com.github.ilyamurzinov.ecareapp.web.controller;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import com.github.ilyamurzinov.ecareapp.web.beans.UserBean;
import com.github.ilyamurzinov.ecareapp.web.dao.AuthorityDAO;
import com.github.ilyamurzinov.ecareapp.web.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author ilya-murzinov
 */
@Component
public class SecurityHelper {
    @Autowired
    private AuthorityService authorityService;

    public UserBean getCurrentUser() {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user;
        if (o instanceof User) {
            user = (User) o;
        } else {
            user = getNullUser();
        }
        UserBean userBean = new UserBean(user);
        userBean.setAdmin(user.getAuthorities().contains(authorityService.getAdminAuthority()));
        return userBean;
    }

    public User getNullUser() {
        User user = new User();
        user.setEmail("nobody");
        return user;
    }
}
