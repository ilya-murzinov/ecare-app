package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class TariffDAOImpl implements TariffDAO {

    private EntityManager entityManager;

    @Override
    public Tariff getTariff(int id) {
        Query query = entityManager.createQuery("select t from Tariff t where t.id = :id").setParameter("id", id);
        return (Tariff) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tariff> getAllTariffs() {
        Query query = entityManager.createQuery("select t from Tariff t");
        return query.getResultList();
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
        Tariff tariff = getTariff(id);
        if (tariff != null) {
            entityManager.remove(tariff);
        }
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
