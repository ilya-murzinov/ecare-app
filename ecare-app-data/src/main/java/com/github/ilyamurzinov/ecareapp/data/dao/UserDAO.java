package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author ilya-murzinov
 */
public interface UserDAO extends DAO {
    User getUser(String login);
    void updateUser(User user);
}
