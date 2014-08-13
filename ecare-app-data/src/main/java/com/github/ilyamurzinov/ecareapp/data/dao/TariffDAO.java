package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface TariffDAO {
    Tariff getTariff(int id);

    List<Tariff> getAllTariffs();

    void addTariff(Tariff tariff);

    void removeTariff(int id);

    void addOption(int tariffId, int optionId);

    void removeOption(int tariffId, int optionId);
}
