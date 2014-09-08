package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractService {
    Contract getContract(int id);

    void updateContract(Contract newContract);

    void addContract(Contract newContract);

    void deleteContract(int id);
}
