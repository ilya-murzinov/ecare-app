package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Repository
public class TariffDAOImpl implements TariffDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private OptionDAO optionDAO;

    @Override
    public Tariff getTariff(int id) {
        return (Tariff) sessionFactory.getCurrentSession().get(Tariff.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tariff> getAllTariffs() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Tariff").list();
    }

    @Override
    public void addTariff(Tariff tariff) {
        sessionFactory.getCurrentSession().save(tariff);
    }

    @Override
    public void removeTariff(int id) {
        Tariff tariff = getTariff(id);
        if (tariff != null) {
            sessionFactory.getCurrentSession().delete(tariff);
        }
    }

    @Override
    public void addOption(int tariffId, int optionId) {
        Tariff tariff = getTariff(tariffId);
        Option option = optionDAO.getOption(optionId);

        tariff.getOptions().add(option);
        sessionFactory.getCurrentSession().update(tariff);
    }

    @Override
    public void removeOption(int tariffId, int optionId) {
        Tariff tariff = getTariff(tariffId);
        Option option = optionDAO.getOption(optionId);

        if (tariff.getOptions().contains(option)) {
            tariff.getOptions().remove(option);
            sessionFactory.getCurrentSession().update(tariff);
        }
    }
}
