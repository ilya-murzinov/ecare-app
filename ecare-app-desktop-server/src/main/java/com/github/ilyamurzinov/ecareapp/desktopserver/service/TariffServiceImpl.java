package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.desktopserver.dao.DAO;
import com.github.ilyamurzinov.ecareapp.desktopserver.dao.TariffDAO;
import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Service
public class TariffServiceImpl extends AbstractService implements TariffService {
    @Autowired
    private TariffDAO tariffDAO;

    @Override
    public Tariff getTariff(int id) {
        try {
            createAndInjectEntityManager();
            return tariffDAO.getTariff(id);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Tariff> getAllTariffs() {
        try {
            createAndInjectEntityManager();
            return tariffDAO.getAllTariffs();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void addTariff(Tariff tariff) {
        try {
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            tariffDAO.addTariff(tariff);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void removeTariff(int id) {
        try {
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            tariffDAO.removeTariff(id);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateTariff(Tariff tariff) {
        try {
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            tariffDAO.updateTariff(tariff);
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
           add(tariffDAO);
        }};
    }
}
