package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface TariffService {
    Tariff getTariff(int id);

    List<Tariff> getAllTariffs();

    String updateTariff(Tariff tariff);

    String addTariff(Tariff tariff);

    String removeTariff(int id);
}
