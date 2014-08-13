package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ilya-murzinov
 */
@Repository
public class OptionDAOImpl implements OptionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Option getOption(int id) {
        return (Option) sessionFactory.getCurrentSession().get(Option.class, id);
    }

    @Override
    public void addOption(Option option) {
        sessionFactory.getCurrentSession().save(option);
    }

    @Override
    public void removeOption(int id) {
        Option option = getOption(id);
        if (option != null) {
            sessionFactory.getCurrentSession().delete(option);
        }
    }
}
