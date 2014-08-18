package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.ContractDAO;
import com.github.ilyamurzinov.ecareapp.data.dao.DAO;
import com.github.ilyamurzinov.ecareapp.data.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            contractDAO.addContract(contract);
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
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            contractDAO.removeContract(id);
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
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            contractDAO.updateContract(contract);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    protected void setDAOs() {
        daos = new ArrayList<DAO>() {{
            add(contractDAO);
        }};
    }
}
