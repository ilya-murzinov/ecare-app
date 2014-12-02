package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractDAO {
    Contract getContract(int id);

    void addContract(Contract contract);

    void removeContract(int id);

    void updateContract(Contract contract);

    java.util.List<Contract> getAllContracts();
}
