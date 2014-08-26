package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractDAO {
    void addContract(Contract contract);

    void removeContract(int id);

    void updateContract(Contract contract);
}
