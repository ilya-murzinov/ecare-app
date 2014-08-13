package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.ContractDAO;
import com.github.ilyamurzinov.ecareapp.data.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilya-murzinov
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDAO contractDAO;

    @Override
    @Transactional
    public void addContract(Contract contract) {
        contractDAO.addContract(contract);
    }

    @Override
    @Transactional
    public void removeContract(int id) {
        contractDAO.removeContract(id);
    }
}
