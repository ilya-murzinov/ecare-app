package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author ilya-murzinov
 */
@Repository
public class ContractDAOImpl implements ContractDAO {

    private EntityManager entityManager;

    @Override
    public void addContract(Contract contract) {
        entityManager.persist(contract);
    }

    @Override
    public void removeContract(int id) {
        Query query = entityManager.createQuery("select c from Contract c where c.id = :id").setParameter("id", id);
        Contract contract = (Contract) query.getSingleResult();
        if (contract != null) {
            entityManager.remove(contract);
        }
    }

    @Override
    public void updateContract(Contract contract) {
        entityManager.merge(contract);
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
