package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author ilya-murzinov
 */
public abstract class AbstractService {
    protected DAO dao;

    protected abstract void setDAO();

    @Autowired
    protected EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    protected void createAndInjectEntityManager() {
        if (dao == null) {
            setDAO();
        }
        entityManager = entityManagerFactory.createEntityManager();
        dao.setEntityManager(entityManager);
    }
}
