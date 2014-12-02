package com.github.ilyamurzinov.ecareapp.service;

import com.github.ilyamurzinov.ecareapp.domain.Option;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface OptionService {
    Option getOption(int id);

    List<Option> getAllOptions();

    void updateOption(Option option);

    void addOption(Option option);

    String removeOption(int id);
}
