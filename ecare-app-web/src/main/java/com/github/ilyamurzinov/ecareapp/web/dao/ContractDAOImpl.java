package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author ilya-murzinov
 */
@Repository
public class ContractDAOImpl implements ContractDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Contract getContract(int id) {
        Query query = entityManager.createQuery("select c from Contract c where c.id = :id")
                .setParameter("id", id);
        return (Contract) query.getSingleResult();
    }

    @Override
    public void addContract(Contract contract) {
        entityManager.persist(contract);
    }

    @Override
    public void removeContract(int id) {
        entityManager.remove(getContract(id));
    }

    @Override
    public void updateContract(Contract contract) {
        entityManager.merge(contract);
    }
}
