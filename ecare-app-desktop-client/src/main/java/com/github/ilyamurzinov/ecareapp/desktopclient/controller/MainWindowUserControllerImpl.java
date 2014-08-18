package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowUserControllerImpl implements MainWindowUserController {
    @Override
    public List<String> getContracts() {
        return new ArrayList<String>(){{
            add("Contract 1");
            add("Contract 2");
        }};
    }
}
