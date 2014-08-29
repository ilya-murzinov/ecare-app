package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ilya-murzinov
 */
public class OptionDAOImpl implements OptionDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Option getOption(int id) {
        return null;
    }

    @Override
    public List<Option> getAllOptions() {
        return null;
    }

    @Override
    public void addOption(Option option) {

    }

    @Override
    public void removeOption(int id) {

    }

    @Override
    public void updateOption(Option option) {

    }
}
