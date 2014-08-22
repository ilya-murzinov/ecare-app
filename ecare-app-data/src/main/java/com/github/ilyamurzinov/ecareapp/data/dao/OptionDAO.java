package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface OptionDAO extends DAO {
    Option getOption(int id);

    List<Option> getAllOptions();

    void addOption(Option option);

    void removeOption(int id);

    void updateOption(Option option);
}
