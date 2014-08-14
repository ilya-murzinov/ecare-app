package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author ilya-murzinov
 */
@Repository
public class OptionDAOImpl implements OptionDAO {

    private EntityManager entityManager;

    @Override
    public Option getOption(int id) {
        Query query = entityManager.createQuery("from Option where id = :id").setParameter("id", id);
        return (Option) query.getSingleResult();
    }

    @Override
    public void addOption(Option option) {
        entityManager.persist(option);
    }

    @Override
    public void removeOption(int id) {
        Option option = getOption(id);
        if (option != null) {
            entityManager.remove(option);
        }
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
