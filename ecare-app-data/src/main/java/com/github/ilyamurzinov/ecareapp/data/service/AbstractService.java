package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * @author ilya-murzinov
 */
public abstract class AbstractService {
    protected List<DAO> daos;

    protected abstract void setDAOs();

    @Autowired
    protected EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    protected void createAndInjectEntityManager() {
        if (daos == null) {
            setDAOs();
        }
        entityManager = entityManagerFactory.createEntityManager();
        for (DAO dao : daos) {
            dao.setEntityManager(entityManager);
        }
    }
}
