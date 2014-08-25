package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.Cache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.ClientService;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.ContractService;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.OptionService;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.TariffService;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.ClientView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowAdminView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.TariffView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.ViewMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;

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
    private ClientView clientView;

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
        mainWindowAdminView.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                updateView();
            }
        });
        mainWindowAdminView.getAddClientButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientView.getClientPanel().setMode(ViewMode.ADD);
                clientView.display();
            }
        });
        mainWindowAdminView.getEditClientButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientView.getClientPanel().setMode(ViewMode.EDIT);
                clientView.display();
            }
        });
        mainWindowAdminView.getAddTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tariffView.getTariffPanel().setMode(ViewMode.ADD);
                Tariff newTariff = new Tariff();
                newTariff.setOptions(new HashSet<Option>());
                cache.setTariff(newTariff);
                tariffView.display();
            }
        });
        mainWindowAdminView.getEditTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tariffView.getTariffPanel().setMode(ViewMode.EDIT);
                Object selectedValue = mainWindowAdminView.getTariffsList().getSelectedValue();
                if (selectedValue != null) {
                    cache.setTariff((Tariff) selectedValue);
                    tariffView.display();
                }
            }
        });
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
