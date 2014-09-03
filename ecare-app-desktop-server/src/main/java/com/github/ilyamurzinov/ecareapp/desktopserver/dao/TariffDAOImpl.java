package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class TariffDAOImpl implements TariffDAO {
    @Override
    public Tariff getTariff(EntityManager entityManager, int id) {
        Query query = entityManager.createQuery("select t from Tariff t where t.id = :id").setParameter("id", id);
        return (Tariff) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tariff> getAllTariffs(EntityManager entityManager) {
        Query query = entityManager.createQuery("select t from Tariff t");
        return query.getResultList();
    }

    @Override
    public void addTariff(EntityManager entityManager, Tariff tariff) {
        entityManager.persist(tariff);
    }

    @Override
    public void updateTariff(EntityManager entityManager, Tariff tariff) {
        entityManager.merge(tariff);
    }

    @Override
    public void removeTariff(EntityManager entityManager, int id) {
        Tariff tariff = getTariff(entityManager, id);
        if (tariff != null) {
            entityManager.remove(tariff);
        }
    }
}
