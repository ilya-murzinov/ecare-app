package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class TariffDAOImpl implements TariffDAO {
    @PersistenceUnit
    public void setEntityManager(EntityManagerFactory entityManagerFactory) {
        entityManager = entityManagerFactory.createEntityManager();
    }

    private EntityManager entityManager;

    @Override
    public Tariff getTariff(int id) {
        Query query = entityManager.createQuery("select t from Tariff t where t.id = :id")
                .setParameter("id", id);
        return (Tariff) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tariff> getAllTariffs() {
        Query query = entityManager.createQuery("select t from Tariff t");
        return (List<Tariff>) query.getResultList();
    }

    @Override
    public void addTariff(Tariff tariff) {
        entityManager.persist(tariff);
    }

    @Override
    public void updateTariff(Tariff tariff) {
        entityManager.merge(tariff);
    }

    @Override
    public void removeTariff(int id) {
        entityManager.remove(getTariff(id));
    }
}
