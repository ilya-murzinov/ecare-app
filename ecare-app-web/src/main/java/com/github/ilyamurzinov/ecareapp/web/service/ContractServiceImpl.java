package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.web.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public void updateContract(Contract newContract) {
        Contract contract = contractDAO.getContract(newContract.getId());
        int tariffId = newContract.getTariff().getId();
        Set<Option> newOptions = newContract.getOptions();
        Set<Option> options = new HashSet<Option>();
        for (Option option : newOptions) {
            options.add(optionDAO.getOption(option.getId()));
        }

        contract.setTariff(tariffDAO.getTariff(tariffId));
        contract.setOptions(options);
        contract.setBlocked(newContract.isBlocked());
        contractDAO.updateContract(contract);
    }

    @Override
    public void addContract(Contract newContract) {
        Contract contract = new Contract();

        contract.setClient(clientDAO.getClient(newContract.getClient().getId()));

        int tariffId = newContract.getTariff().getId();
        Set<Option> newOptions = newContract.getOptions();
        Set<Option> options = new HashSet<Option>();
        for (Option option : newOptions) {
            options.add(optionDAO.getOption(option.getId()));
        }

        contract.setNumber(newContract.getNumber());
        contract.setTariff(tariffDAO.getTariff(tariffId));
        contract.setOptions(options);
        contractDAO.addContract(contract);
    }

    @Override
    public void deleteContract(int id) {
        Client client = contractDAO.getContract(id).getClient();
        client.getContracts().remove(contractDAO.getContract(id));
        clientDAO.updateClient(client);
        contractDAO.removeContract(id);
    }
}
