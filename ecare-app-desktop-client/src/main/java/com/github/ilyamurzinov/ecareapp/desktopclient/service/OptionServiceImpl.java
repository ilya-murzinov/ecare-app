package com.github.ilyamurzinov.ecareapp.desktopclient.service;

import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ilya-murzinov
 */
@Component
public class OptionServiceImpl implements OptionService {
    @Autowired
    private ConnectionHelper helper;

    @Override
    public Option getOption(int id) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Option> getAllOptions() {
        helper.sendRequest("GET_ALL", new Option());
        return (List<Option>) helper.readObject();
    }

    @Override
    public void addOption(Option option) {

    }

    @Override
    public void removeOption(int id) {

    }

    @Override
    public void updateOption(Option option) {

    }
}
