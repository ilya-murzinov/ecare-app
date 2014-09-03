package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.desktopserver.dao.TariffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            createEntityManager();
            return tariffDAO.getTariff(entityManager, id);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Tariff> getAllTariffs() {
        try {
            createEntityManager();
            return tariffDAO.getAllTariffs(entityManager);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void addTariff(Tariff tariff) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            tariffDAO.addTariff(entityManager, tariff);
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
            createEntityManager();
            entityManager.getTransaction().begin();
            tariffDAO.removeTariff(entityManager, id);
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
            createEntityManager();
            entityManager.getTransaction().begin();
            tariffDAO.updateTariff(entityManager, tariff);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
