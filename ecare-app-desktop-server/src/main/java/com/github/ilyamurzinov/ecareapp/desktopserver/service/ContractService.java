package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractService {
    void addContract(Contract contract);

    void removeContract(int id);

    void updateContract(Contract contract);
}
