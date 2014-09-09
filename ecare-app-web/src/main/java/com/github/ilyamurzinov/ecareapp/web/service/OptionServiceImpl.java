package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Option;
import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.web.dao.OptionDAO;
import com.github.ilyamurzinov.ecareapp.web.dao.TariffDAO;
import com.github.ilyamurzinov.ecareapp.web.dao.TariffDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    private TariffDAO tariffDAO;

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
    public String removeOption(int id) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Tariff tariff : tariffDAO.getAllTariffs()) {
            if (tariff.getOptions().contains(getOption(id))) {
                stringBuilder.append("Cannot delete option with id ");
                stringBuilder.append(id);
                stringBuilder.append("\nThis option present in tariff \"");
                stringBuilder.append(tariff);
                stringBuilder.append("\"\n");
            }
        }

        if (stringBuilder.length() != 0) {
            return stringBuilder.toString();
        }

        optionDAO.removeOption(id);
        return null;
    }
}
