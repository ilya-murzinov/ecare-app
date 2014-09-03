package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 * @author ilya-murzinov
 */
public abstract class AbstractService {
    @PersistenceUnit
    protected EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    protected void createEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }
}
