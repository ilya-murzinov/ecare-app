package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface TariffService {
    Tariff getTariff(int id);

    List<Tariff> getAllTariffs();

    void addTariff(Tariff tariff);

    void removeTariff(int id);

    void updateTariff(Tariff tariff);
}
