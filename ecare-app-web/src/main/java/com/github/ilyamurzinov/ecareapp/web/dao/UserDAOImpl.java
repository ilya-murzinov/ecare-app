package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ilya-murzinov
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String login) {
        return (User) sessionFactory.getCurrentSession().createQuery("select u from User u where u.email = :login")
                .setParameter("login", login)
                .uniqueResult();
    }

    @Override
    public void updateUser(User user) {

    }
}
