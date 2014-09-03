package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class OptionDAOImpl implements OptionDAO {
    @Override
    public com.github.ilyamurzinov.ecareapp.common.domain.Option getOption(EntityManager entityManager, int id) {
        Query query = entityManager.createQuery("select o from Option o where o.id = :id").setParameter("id", id);
        return (com.github.ilyamurzinov.ecareapp.common.domain.Option) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<com.github.ilyamurzinov.ecareapp.common.domain.Option> getAllOptions(EntityManager entityManager) {
        Query query = entityManager.createQuery("select o from Option o");
        return (List<com.github.ilyamurzinov.ecareapp.common.domain.Option>) query.getResultList();
    }

    @Override
    public void addOption(EntityManager entityManager, Option option) {
        entityManager.persist(option);
    }

    @Override
    public void removeOption(EntityManager entityManager, int id) {
        Option option = getOption(entityManager, id);
        if (option != null) {
            entityManager.remove(option);
        }
    }

    @Override
    public void updateOption(EntityManager entityManager, Option option) {
        entityManager.merge(option);
    }
}
