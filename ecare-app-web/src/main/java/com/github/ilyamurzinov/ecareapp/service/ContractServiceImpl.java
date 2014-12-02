package com.github.ilyamurzinov.ecareapp.service;

import com.github.ilyamurzinov.ecareapp.domain.Client;
import com.github.ilyamurzinov.ecareapp.domain.Contract;
import com.github.ilyamurzinov.ecareapp.domain.Option;
import com.github.ilyamurzinov.ecareapp.dao.ClientDAO;
import com.github.ilyamurzinov.ecareapp.dao.ContractDAO;
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
    public List<Contract> getAllContracts() {
        return contractDAO.getAllContracts();
    }

    @Override
    public String updateContract(Contract newContract) {
        if (contractDAO.getAllContracts().contains(newContract)) {
            return "Contract with the same number already exists";
        }

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
        if (contractDAO.getAllContracts().contains(newContract)) {
            return "Contract with the same number already exists";
        }

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
