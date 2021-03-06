package com.github.ilyamurzinov.ecareapp.service;

import com.github.ilyamurzinov.ecareapp.common.Util;
import com.github.ilyamurzinov.ecareapp.domain.User;
import com.github.ilyamurzinov.ecareapp.controller.PasswordException;
import com.github.ilyamurzinov.ecareapp.dao.AuthorityDAO;
import com.github.ilyamurzinov.ecareapp.dao.ClientDAO;
import com.github.ilyamurzinov.ecareapp.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private AuthorityDAO authorityDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.getUser(login);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException(login);
    }

    @Override
    public void changePassword(int id, String currentPassword, String newPassword) {
        User user = userDAO.getUser(id);
        if (!Util.getMd5Hash(currentPassword).equals(user.getPassword())) {
            throw new PasswordException("Current password is invalid");
        }
        user.setPassword(Util.getMd5Hash(newPassword));
        userDAO.updateUser(user);
    }

    @Override
    public void addClient(String email, String password, int clientId) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(Util.getMd5Hash(password));
        user.getAuthorities().add(authorityDAO.getAuthority("ROLE_CLIENT"));
        user.setClient(clientDAO.getClient(clientId));
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        User user1 = userDAO.getUser(user.getId());
        user1.setEnabled(user.isEnabled());
        userDAO.updateUser(user1);
    }
}
