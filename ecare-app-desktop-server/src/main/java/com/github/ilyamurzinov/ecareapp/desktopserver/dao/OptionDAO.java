package com.github.ilyamurzinov.ecareapp.desktopserver.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface OptionDAO {
    Option getOption(EntityManager entityManager, int id);

    List<Option> getAllOptions(EntityManager entityManager);

    void addOption(EntityManager entityManager, Option option);

    void removeOption(EntityManager entityManager, int id);

    void updateOption(EntityManager entityManager, Option option);
}
