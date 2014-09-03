package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.desktopserver.dao.ContractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ilya-murzinov
 */
@Service
public class ContractServiceImpl extends AbstractService implements ContractService {
    @Autowired
    private ContractDAO contractDAO;

    @Override
    public void addContract(Contract contract) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            contractDAO.addContract(entityManager, contract);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void removeContract(int id) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            contractDAO.removeContract(entityManager, id);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateContract(Contract contract) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            contractDAO.updateContract(entityManager, contract);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
