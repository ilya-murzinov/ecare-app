package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class TariffDAOImpl implements TariffDAO {

    private EntityManager entityManager;

    @Autowired
    private OptionDAO optionDAO;

    @Override
    public Tariff getTariff(int id) {
        Query query = entityManager.createQuery("from Tariff where id = :id").setParameter("id", id);
        return (Tariff) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tariff> getAllTariffs() {
        Query query = entityManager.createQuery("from Tariff");
        return query.getResultList();
    }

    @Override
    public void addTariff(Tariff tariff) {
        entityManager.persist(tariff);
    }

    @Override
    public void removeTariff(int id) {
        Tariff tariff = getTariff(id);
        if (tariff != null) {
            entityManager.remove(tariff);
        }
    }

    @Override
    public void addOption(int tariffId, int optionId) {
        
    }

    @Override
    public void removeOption(int tariffId, int optionId) {
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
