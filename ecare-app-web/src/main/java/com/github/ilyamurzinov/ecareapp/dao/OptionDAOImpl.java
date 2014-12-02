package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.Option;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class OptionDAOImpl implements OptionDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Option getOption(int id) {
        Query query = entityManager.createQuery("select o from Option o where o.id = :id")
                .setParameter("id", id);
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
        entityManager.remove(getOption(id));
    }

    @Override
    public void updateOption(Option option) {
        entityManager.merge(option);
    }
}
