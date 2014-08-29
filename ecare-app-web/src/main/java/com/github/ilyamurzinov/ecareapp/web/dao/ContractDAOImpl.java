package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ilya-murzinov
 */
public class ContractDAOImpl implements ContractDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addContract(Contract contract) {

    }

    @Override
    public void removeContract(int id) {

    }

    @Override
    public void updateContract(Contract contract) {

    }
}
