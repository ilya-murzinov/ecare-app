package com.github.ilyamurzinov.ecareapp.service;

import com.github.ilyamurzinov.ecareapp.domain.Contract;

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
