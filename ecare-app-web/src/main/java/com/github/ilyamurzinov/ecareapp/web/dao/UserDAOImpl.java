package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.User;
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
        Query query = entityManager.createQuery("select u from User u where u.id = :id")
                .setParameter("id", id);
        return (User) query.getSingleResult();
    }

    @Override
    public User getUser(String login) {
        Query query = entityManager.createQuery("select u from User u where u.email = :login")
                .setParameter("login", login);
        return (User) query.getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
}
