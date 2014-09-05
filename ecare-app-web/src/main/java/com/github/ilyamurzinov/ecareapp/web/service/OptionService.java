package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;

import java.util.List;

/**
 * @author ilya-murzinov
 */
public interface OptionService {
    Option getOption(int id);

    List<Option> getAllOptions();
}
