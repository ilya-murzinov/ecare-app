package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface TariffDAO extends DAO {
    Tariff getTariff(int id);

    List<Tariff> getAllTariffs();

    void addTariff(Tariff tariff);

    void updateTariff(Tariff tariff);

    void removeTariff(int id);
}
