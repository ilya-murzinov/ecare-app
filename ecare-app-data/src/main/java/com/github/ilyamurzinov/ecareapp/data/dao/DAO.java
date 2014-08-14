package com.github.ilyamurzinov.ecareapp.data.dao;

import javax.persistence.EntityManager;

/**
 * @author ilya-murzinov
 */
public interface DAO {
    void setEntityManager(EntityManager entityManager);
}
