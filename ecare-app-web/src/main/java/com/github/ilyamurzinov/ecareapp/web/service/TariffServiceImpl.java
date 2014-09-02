package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.web.dao.TariffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class TariffServiceImpl implements TariffService {
    @Autowired
    private TariffDAO tariffDAO;

    @Override
    public Tariff getTariff(int id) {
        return tariffDAO.getTariff(id);
    }

    @Override
    public List<Tariff> getAllTariffs() {
        return tariffDAO.getAllTariffs();
    }
}
