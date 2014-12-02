package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.Contract;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    @Override
    public List<Contract> getAllContracts() {
        Query query = entityManager.createQuery("select c from Contract c");
        return query.getResultList();
    }
}
