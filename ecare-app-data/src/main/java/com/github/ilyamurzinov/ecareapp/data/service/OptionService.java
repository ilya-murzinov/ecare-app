package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;

/**
 * @author ilya-murzinov
 */
public interface OptionService {
    Option getOption(int id);

    void addOption(Option option);

    void removeOption(int id);

    void updateOption(Option option);
}
