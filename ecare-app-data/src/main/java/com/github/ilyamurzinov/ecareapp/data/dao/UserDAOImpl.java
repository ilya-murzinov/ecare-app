package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * @author ilya-murzinov
 */
@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;

    @Override
    public User getUser(String login) {
        Query query = entityManager.createQuery("select u from User u where u.login = :login").setParameter("login", login);
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
