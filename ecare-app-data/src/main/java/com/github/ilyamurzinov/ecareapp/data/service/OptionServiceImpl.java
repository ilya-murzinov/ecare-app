package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.DAO;
import com.github.ilyamurzinov.ecareapp.data.dao.OptionDAO;
import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
            createAndInjectEntityManager();
            return optionDAO.getOption(id);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void addOption(Option option) {
        try {
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            optionDAO.addOption(option);
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
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            optionDAO.removeOption(id);
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
            createAndInjectEntityManager();
            entityManager.getTransaction().begin();
            optionDAO.updateOption(option);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    protected void setDAOs() {
        daos = new ArrayList<DAO>(){{
            add(optionDAO);
        }};
    }
}
