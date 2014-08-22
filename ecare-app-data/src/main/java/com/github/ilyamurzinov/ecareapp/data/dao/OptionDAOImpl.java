package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class OptionDAOImpl implements OptionDAO {

    private EntityManager entityManager;

    @Override
    public Option getOption(int id) {
        Query query = entityManager.createQuery("select o from Option o where o.id = :id").setParameter("id", id);
        return (Option) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Option> getAllOptions() {
        Query query = entityManager.createQuery("select o from Option o");
        return (List<Option>) query.getResultList();
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
    public void updateOption(Option option) {
        entityManager.merge(option);
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
