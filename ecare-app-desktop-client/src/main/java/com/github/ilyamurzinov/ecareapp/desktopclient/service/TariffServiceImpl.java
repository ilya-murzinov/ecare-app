package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Component
public class TariffServiceImpl implements TariffService {
    @Autowired
    private ConnectionHelper helper;

    @Override
    public Tariff getTariff(int id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tariff> getAllTariffs() {
        helper.sendRequest("GET_ALL", new Tariff());
        return (List<Tariff>) helper.readObject();
    }

    @Override
    public void addTariff(Tariff tariff) {

    }

    @Override
    public void removeTariff(int id) {

    }

    @Override
    public void addOption(Tariff tariff, Option option) {

    }

    @Override
    public void removeOption(Tariff tariff, Option option) {

    }

    @Override
    public void updateTariff(Tariff tariff) {
        helper.sendRequest("POST", tariff);
    }
}
