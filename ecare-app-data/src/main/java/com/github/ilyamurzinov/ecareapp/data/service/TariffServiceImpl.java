package com.github.ilyamurzinov.ecareapp.data.service;

import com.github.ilyamurzinov.ecareapp.data.dao.TariffDAO;
import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Service
public class TariffServiceImpl implements TariffService {
    @Autowired
    private TariffDAO tariffDAO;

    @Override
    @Transactional
    public Tariff getTariff(int id) {
        return tariffDAO.getTariff(id);
    }

    @Override
    @Transactional
    public List<Tariff> getAllTariffs() {
        return tariffDAO.getAllTariffs();
    }

    @Override
    @Transactional
    public void addTariff(Tariff tariff) {
        tariffDAO.addTariff(tariff);
    }

    @Override
    @Transactional
    public void removeTariff(int id) {
        tariffDAO.removeTariff(id);
    }

    @Override
    @Transactional
    public void addOption(int tariffId, int optionId) {
        tariffDAO.addOption(tariffId, optionId);
    }

    @Override
    @Transactional
    public void removeOption(int tariffId, int optionId) {
        tariffDAO.removeOption(tariffId, optionId);
    }
}
