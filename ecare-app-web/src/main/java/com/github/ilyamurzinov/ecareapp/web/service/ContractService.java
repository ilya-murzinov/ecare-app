package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractService {
    Contract getContract(int id);

    java.util.List<Contract> getAllContracts();

    String updateContract(Contract newContract);

    String addContract(Contract newContract);

    void deleteContract(int id);
}
