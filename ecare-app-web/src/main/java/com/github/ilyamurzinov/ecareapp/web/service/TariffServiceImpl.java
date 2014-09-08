package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.web.dao.OptionDAO;
import com.github.ilyamurzinov.ecareapp.web.dao.TariffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class TariffServiceImpl implements TariffService {
    @Autowired
    private TariffDAO tariffDAO;

    @Autowired
    private OptionDAO optionDAO;

    @Override
    public Tariff getTariff(int id) {
        return tariffDAO.getTariff(id);
    }

    @Override
    public List<Tariff> getAllTariffs() {
        return tariffDAO.getAllTariffs();
    }

    @Override
    public void updateTariff(Tariff newTariff) {
        Tariff tariff = tariffDAO.getTariff(newTariff.getId());

        Set<Option> options = new HashSet<Option>();
        for (Option option : newTariff.getOptions()) {
            options.add(optionDAO.getOption(option.getId()));
        }

        tariff.setName(newTariff.getName());
        tariff.setPrice(newTariff.getPrice());
        tariff.setOptions(options);

        tariffDAO.updateTariff(tariff);
    }

    @Override
    public void addTariff(Tariff newTariff) {
        Tariff tariff = new Tariff();

        Set<Option> options = new HashSet<Option>();
        for (Option option : newTariff.getOptions()) {
            options.add(optionDAO.getOption(option.getId()));
        }

        tariff.setName(newTariff.getName());
        tariff.setPrice(newTariff.getPrice());
        tariff.setOptions(options);

        tariffDAO.addTariff(tariff);
    }

    @Override
    public void removeTariff(int id) {
        tariffDAO.removeTariff(id);
    }
}
