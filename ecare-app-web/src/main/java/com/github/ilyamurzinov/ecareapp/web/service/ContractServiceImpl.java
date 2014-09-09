package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.web.dao.ClientDAO;
import com.github.ilyamurzinov.ecareapp.web.dao.ContractDAO;
import com.github.ilyamurzinov.ecareapp.web.dao.OptionDAO;
import com.github.ilyamurzinov.ecareapp.web.dao.TariffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private OptionDAO optionDAO;

    @Autowired
    private TariffDAO tariffDAO;

    @Override
    public Contract getContract(int id) {
        return contractDAO.getContract(id);
    }

    @Override
    public String updateContract(Contract newContract) {
        Contract contract = contractDAO.getContract(newContract.getId());
        int tariffId = newContract.getTariff().getId();
        Set<Option> newOptions = newContract.getOptions();
        Set<Option> options = new HashSet<Option>();
        for (Option option : newOptions) {
            options.add(optionDAO.getOption(option.getId()));
        }

        String message = OptionsValidator.validate(options);
        if (message != null) {
            return message;
        }

        contract.setTariff(tariffDAO.getTariff(tariffId));
        contract.setOptions(options);
        contract.setBlocked(newContract.isBlocked());
        contract.setBlockedByEmployee(newContract.isBlockedByEmployee());
        contractDAO.updateContract(contract);

        return null;
    }

    @Override
    public String addContract(Contract newContract) {
        Contract contract = new Contract();

        contract.setClient(clientDAO.getClient(newContract.getClient().getId()));

        int tariffId = newContract.getTariff().getId();
        Set<Option> newOptions = newContract.getOptions();
        Set<Option> options = new HashSet<Option>();
        for (Option option : newOptions) {
            options.add(optionDAO.getOption(option.getId()));
        }

        String message = OptionsValidator.validate(options);
        if (message != null) {
            return message;
        }

        contract.setNumber(newContract.getNumber());
        contract.setTariff(tariffDAO.getTariff(tariffId));
        contract.setOptions(options);
        contractDAO.addContract(contract);

        return null;
    }

    @Override
    public void deleteContract(int id) {
        Client client = contractDAO.getContract(id).getClient();
        client.getContracts().remove(contractDAO.getContract(id));
        clientDAO.updateClient(client);
        contractDAO.removeContract(id);
    }
}
