package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.Cache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.ClientService;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.ContractService;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.OptionService;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.TariffService;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowAdminView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.TariffView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowAdminController {
    @Autowired
    private MainWindowAdminView mainWindowAdminView;

    @Autowired
    private TariffView tariffView;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private Cache cache;

    @PostConstruct
    public void init() {
        tariffView.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent e) {
                updateView();
            }
        });
        mainWindowAdminView.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                initView();
            }
        });
        mainWindowAdminView.getAddTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tariffView.display();
            }
        });
        mainWindowAdminView.getEditTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cache.setTariff((Tariff) mainWindowAdminView.getTariffsList().getSelectedValue());
                tariffView.display();
            }
        });
    }

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

    public void updateView() {
        mainWindowAdminView.getClientsListModel().removeAllElements();
        mainWindowAdminView.getTariffsListModel().removeAllElements();
        mainWindowAdminView.getOptionsListModel().removeAllElements();

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
