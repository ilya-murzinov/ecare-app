package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Contract;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ilya-murzinov
 */
@Repository
public class ContractDAOImpl implements ContractDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addContract(Contract contract) {
        sessionFactory.getCurrentSession().save(contract);
    }

    @Override
    public void removeContract(int id) {
        Contract contract = (Contract) sessionFactory.getCurrentSession().get(Contract.class, id);
        if (contract != null) {
            sessionFactory.getCurrentSession().delete(contract);
        }
    }
}
