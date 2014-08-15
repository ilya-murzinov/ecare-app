package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;

/**
 * @author ilya-murzinov
 */
public interface OptionService {
    Option getOption(int id);

    void addOption(Option option);

    void removeOption(int id);
}
