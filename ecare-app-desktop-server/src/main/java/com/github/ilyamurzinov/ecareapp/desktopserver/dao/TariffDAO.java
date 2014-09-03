package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface TariffDAO {
    Tariff getTariff(EntityManager entityManager, int id);

    List<Tariff> getAllTariffs(EntityManager entityManager);

    void addTariff(EntityManager entityManager, Tariff tariff);

    void updateTariff(EntityManager entityManager, Tariff tariff);

    void removeTariff(EntityManager entityManager, int id);
}
