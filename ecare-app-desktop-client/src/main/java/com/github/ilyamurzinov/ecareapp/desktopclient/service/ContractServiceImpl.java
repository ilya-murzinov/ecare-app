package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ilya-murzinov
 */
@Component
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ConnectionHelper helper;

    @Override
    public void addContract(Contract contract) {

    }

    @Override
    public void removeContract(int id) {

    }

    @Override
    public void updateContract(Contract contract) {
        helper.sendRequest("POST", contract);
    }
}
