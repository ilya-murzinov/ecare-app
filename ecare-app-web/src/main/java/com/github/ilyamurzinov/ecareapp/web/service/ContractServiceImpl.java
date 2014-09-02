package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.web.dao.ContractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDAO contractDAO;

    @Override
    public Contract getContract(int id) {
        return contractDAO.getContract(id);
    }

    @Override
    public void updateContract(Contract contract) {
        contractDAO.updateContract(contract);
    }
}
