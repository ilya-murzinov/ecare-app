package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractDAO {
    Contract getContract(int id);

    void addContract(Contract contract);

    void removeContract(int id);

    void updateContract(Contract contract);
}
