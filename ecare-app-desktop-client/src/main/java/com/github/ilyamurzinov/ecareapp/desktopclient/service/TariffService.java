package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface TariffService {
    Tariff getTariff(int id);

    List<Tariff> getAllTariffs();

    void addTariff(Tariff tariff);

    void removeTariff(int id);

    void addOption(Tariff tariff, Option option);

    void removeOption(Tariff tariff, Option option);
}
