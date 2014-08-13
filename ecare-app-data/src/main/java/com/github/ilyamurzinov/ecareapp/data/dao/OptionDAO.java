package com.github.ilyamurzinov.ecareapp.data.dao;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;

/**
 * @author ilya-murzinov
 */
public interface OptionDAO {
    Option getOption(int id);

    void addOption(Option option);

    void removeOption(int id);
}
