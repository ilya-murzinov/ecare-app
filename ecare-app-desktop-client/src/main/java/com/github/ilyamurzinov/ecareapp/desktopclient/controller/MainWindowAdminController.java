package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.data.domain.*;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.ClientCache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.*;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowAdminController {
    @Autowired
    private MainWindowAdminView mainWindowAdminView;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private ContractService contractService;

    private Contract currentContract;

    public void initView() {
        for (Client client : clientService.getAllClients()) {
            mainWindowAdminView.getClientsListModel().addElement(client);
        }
        for (Tariff tariff : tariffService.getAllTariffs()) {
            mainWindowAdminView.getTariffsListModel().addElement(tariff);
        }
        for (Option option : optionService.getAllOptions()) {
            mainWindowAdminView.getOptionsListModel().addElement(option);
        }
    }
}
