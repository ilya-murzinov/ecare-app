package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ilya-murzinov
 */
public class TariffDAOImpl implements TariffDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Tariff getTariff(int id) {
        return null;
    }

    @Override
    public List<Tariff> getAllTariffs() {
        return null;
    }

    @Override
    public void addTariff(Tariff tariff) {

    }

    @Override
    public void updateTariff(Tariff tariff) {

    }

    @Override
    public void removeTariff(int id) {

    }
}
