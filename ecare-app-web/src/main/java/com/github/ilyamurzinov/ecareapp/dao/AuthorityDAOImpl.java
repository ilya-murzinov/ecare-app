package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.Authority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ilya-murzinov
 */
@Repository
public class AuthorityDAOImpl implements AuthorityDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Authority getAuthority(String name) {
        return (Authority) entityManager.createQuery("select a from Authority a where a.authority = :name")
                .setParameter("name", name).getSingleResult();
    }
}
