package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;

/**
 * @author ilya-murzinov
 */
public interface ContractDAO extends DAO {
    void addContract(Contract contract);

    void removeContract(int id);

    void updateContract(Contract contract);
}
