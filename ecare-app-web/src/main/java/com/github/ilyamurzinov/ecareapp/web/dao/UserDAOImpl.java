package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author ilya-murzinov
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(int id) {
        //return (User) sessionFactory.getCurrentSession().get(User.class, id);
        return null;
    }

    @Override
    public User getUser(String login) {
        Query query = entityManager.createQuery("select u from User u where u.email = :login")
                .setParameter("login", login);
        return (User) query.getSingleResult();
    }

    @Override
    public void updateUser(User user) {
//        sessionFactory.getCurrentSession().update(user);
    }
}
