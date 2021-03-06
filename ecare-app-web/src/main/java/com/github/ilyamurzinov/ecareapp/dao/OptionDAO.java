package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.Option;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface OptionDAO {
    Option getOption(int id);

    List<Option> getAllOptions();

    void addOption(Option option);

    void removeOption(int id);

    void updateOption(Option option);
}
