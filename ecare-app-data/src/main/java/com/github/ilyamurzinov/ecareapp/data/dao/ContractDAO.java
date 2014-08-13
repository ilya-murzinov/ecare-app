package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractDAO {
    void addContract(Contract contract);

    void removeContract(int id);
}
