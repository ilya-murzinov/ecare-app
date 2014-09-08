package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.web.dao.OptionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Option> getAllOptions() {
        return optionDAO.getAllOptions();
    }

    @Override
    public void updateOption(Option option) {
        optionDAO.updateOption(option);
    }

    @Override
    public void addOption(Option option) {
        optionDAO.addOption(option);
    }

    @Override
    public void removeOption(int id) {
        optionDAO.removeOption(id);
    }
}
