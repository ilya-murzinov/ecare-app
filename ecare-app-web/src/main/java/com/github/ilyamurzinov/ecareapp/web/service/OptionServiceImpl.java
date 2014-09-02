package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.web.dao.OptionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionDAO optionDAO;

    @Override
    public Option getOption(int id) {
        return optionDAO.getOption(id);
    }
}
