package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;

import javax.persistence.EntityManager;

/**
 * @author ilya-murzinov
 */
public interface ContractDAO {
    void addContract(EntityManager entityManager, Contract contract);

    void removeContract(EntityManager entityManager, int id);

    void updateContract(EntityManager entityManager, Contract contract);
}
