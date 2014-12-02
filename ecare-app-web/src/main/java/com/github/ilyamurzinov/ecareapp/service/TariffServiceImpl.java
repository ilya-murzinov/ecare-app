package com.github.ilyamurzinov.ecareapp.service;

import com.github.ilyamurzinov.ecareapp.domain.Contract;
import com.github.ilyamurzinov.ecareapp.domain.Option;
import com.github.ilyamurzinov.ecareapp.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.dao.OptionDAO;
import com.github.ilyamurzinov.ecareapp.dao.TariffDAO;
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

    @Autowired
    private ContractService contractService;

    @Override
    public Tariff getTariff(int id) {
        return tariffDAO.getTariff(id);
    }

    @Override
    public List<Tariff> getAllTariffs() {
        return tariffDAO.getAllTariffs();
    }

    @Override
    public String updateTariff(Tariff newTariff) {
        Tariff tariff = tariffDAO.getTariff(newTariff.getId());

        Set<Option> options = new HashSet<Option>();
        for (Option option : newTariff.getOptions()) {
            options.add(optionDAO.getOption(option.getId()));
        }

        String message = OptionsValidator.validate(options);
        if (message != null) {
            return message;
        }

        tariff.setName(newTariff.getName());
        tariff.setPrice(newTariff.getPrice());
        tariff.setOptions(options);

        tariffDAO.updateTariff(tariff);
        return null;
    }

    @Override
    public String addTariff(Tariff newTariff) {
        Tariff tariff = new Tariff();

        Set<Option> options = new HashSet<Option>();
        for (Option option : newTariff.getOptions()) {
            options.add(optionDAO.getOption(option.getId()));
        }

        String message = OptionsValidator.validate(options);
        if (message != null) {
            return message;
        }

        tariff.setName(newTariff.getName());
        tariff.setPrice(newTariff.getPrice());
        tariff.setOptions(options);

        tariffDAO.addTariff(tariff);
        return null;
    }

    @Override
    public String removeTariff(int id) {
        for (Contract contract : contractService.getAllContracts()) {
            if (contract.getTariff().getId() == id) {
                return "Cannot delete tariff with id " +
                        id +
                        "\nThere is contract " +
                        contract +
                        " with this tariff";
            }
        }

        tariffDAO.removeTariff(id);
        return null;
    }
}
