package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class OptionDAOImpl implements com.github.ilyamurzinov.ecareapp.desktopserver.dao.OptionDAO {

    private EntityManager entityManager;

    @Override
    public com.github.ilyamurzinov.ecareapp.common.domain.Option getOption(int id) {
        Query query = entityManager.createQuery("select o from Option o where o.id = :id").setParameter("id", id);
        return (com.github.ilyamurzinov.ecareapp.common.domain.Option) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<com.github.ilyamurzinov.ecareapp.common.domain.Option> getAllOptions() {
        Query query = entityManager.createQuery("select o from Option o");
        return (List<com.github.ilyamurzinov.ecareapp.common.domain.Option>) query.getResultList();
    }

    @Override
    public void addOption(com.github.ilyamurzinov.ecareapp.common.domain.Option option) {
        entityManager.persist(option);
    }

    @Override
    public void removeOption(int id) {
        com.github.ilyamurzinov.ecareapp.common.domain.Option option = getOption(id);
        if (option != null) {
            entityManager.remove(option);
        }
    }

    @Override
    public void updateOption(com.github.ilyamurzinov.ecareapp.common.domain.Option option) {
        entityManager.merge(option);
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
