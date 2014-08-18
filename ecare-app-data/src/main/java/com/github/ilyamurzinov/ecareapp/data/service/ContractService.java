package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractService {
    void addContract(Contract contract);

    void removeContract(int id);

    void updateContract(Contract contract);
}
