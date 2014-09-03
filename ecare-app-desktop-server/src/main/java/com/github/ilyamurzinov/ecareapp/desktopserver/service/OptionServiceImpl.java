package com.github.ilyamurzinov.ecareapp.desktopserver.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.desktopserver.dao.OptionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Service
public class OptionServiceImpl extends AbstractService implements OptionService {
    @Autowired
    private OptionDAO optionDAO;

    @Override
    public Option getOption(int id) {
        try {
            createEntityManager();
            return optionDAO.getOption(entityManager, id);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Option> getAllOptions() {
        try {
            createEntityManager();
            return optionDAO.getAllOptions(entityManager);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void addOption(Option option) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            optionDAO.addOption(entityManager, option);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void removeOption(int id) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            optionDAO.removeOption(entityManager, id);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateOption(Option option) {
        try {
            createEntityManager();
            entityManager.getTransaction().begin();
            optionDAO.updateOption(entityManager, option);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
