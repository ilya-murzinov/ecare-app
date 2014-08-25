package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.data.domain.*;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.Cache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.*;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.*;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowUserController {
    @Autowired
    private MainWindowUserView mainWindowUserView;

    @Autowired
    private OptionsListView optionsListView;

    @Autowired
    private Cache cache;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private ContractService contractService;

    private boolean initialized;

    @PostConstruct
    public void init() {
        mainWindowUserView.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                updateView();
            }
        });

        /*
        Contracts tab
         */
        mainWindowUserView.getContractPanel().getTariffComboBox().setEnabled(false);

        mainWindowUserView.getContractPanel().getContractsComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (initialized && e.getStateChange() == ItemEvent.SELECTED) {
                    cache.setContract((Contract) e.getItem());
                    updateContractsTab();
                }
            }
        });
        mainWindowUserView.getContractPanel().getChangeTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainWindowUserView.getContractPanel().getTariffComboBox().setEnabled(true);
            }
        });
        mainWindowUserView.getContractPanel().getSaveTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Tariff tariff = (Tariff) mainWindowUserView.getContractPanel().getTariffComboBox().getSelectedItem();
                cache.getContract().setTariff(tariff);
                contractService.updateContract(cache.getContract());
                mainWindowUserView.getContractPanel().getTariffComboBox().setEnabled(false);
            }
        });

        mainWindowUserView.getContractPanel().getAddOptionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                optionsListView.display();
            }
        });

        /*
        Options list
         */
        optionsListView.getAddButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Option option = (Option) optionsListView.getOptionsList().getSelectedValue();
                if (!cache.getContract().getOptions().contains(option)) {
                    cache.getContract().getOptions().add(option);
                    mainWindowUserView.getContractPanel().getOptionsListModel().addElement(option);
                    optionsListView.close();
                } else {
                    new DialogView(mainWindowUserView.getFrame(), "Error", "You already have this option")
                            .display();
                }
            }
        });
    }

    public void updateView() {
        updateContractsTab();
        updateMyDataTab();
    }

    public void updateContractsTab() {
        if (cache.getContract() == null) {
            cache.setContract(cache.getClient().getContracts().get(0));
        }

        mainWindowUserView.getContractPanel().getTariffComboBox().removeAllItems();
        mainWindowUserView.getContractPanel().getOptionsListModel().removeAllElements();

        if (!initialized) {
            mainWindowUserView.getContractPanel().getContractsComboBox().removeAllItems();
            for (Contract contract : cache.getClient().getContracts()) {
                mainWindowUserView.getContractPanel().getContractsComboBox().addItem(contract);
            }
            initialized = true;
        }
        for (Tariff tariff : tariffService.getAllTariffs()) {
            mainWindowUserView.getContractPanel().getTariffComboBox().addItem(tariff);
        }
        mainWindowUserView.getContractPanel().getTariffComboBox().setSelectedItem(cache.getContract().getTariff());

        for (Option option : cache.getContract().getOptions()) {
            mainWindowUserView.getContractPanel().getOptionsListModel().addElement(option);
        }

        for (Option option : cache.getContract().getTariff().getOptions()) {
            optionsListView.getOptionsListModel().addElement(option);
        }
    }

    public void updateMyDataTab() {
        mainWindowUserView.getClientPanel().getNameTextField().setText(cache.getClient().getName());
        mainWindowUserView.getClientPanel().getLastNameTextField().setText(cache.getClient().getLastname());
        mainWindowUserView.getClientPanel().getPassportTextField().setText(cache.getClient().getPassport());
        mainWindowUserView.getClientPanel().getDateOdBirthTestField().setText(cache.getClient().getDateOfBirth());
        mainWindowUserView.getClientPanel().getAddressTextField().setText(cache.getClient().getAddress());
        mainWindowUserView.getClientPanel().getEmailTestField().setText(cache.getClient().getEmail());
    }
}
