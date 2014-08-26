package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import javax.persistence.EntityManager;

/**
 * @author ilya-murzinov
 */
public interface DAO {
    void setEntityManager(EntityManager entityManager);
}
