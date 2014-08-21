package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.data.domain.*;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.ClientCache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.*;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowUserView;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.OptionsListView;
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
    private ClientCache clientCache;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private ContractService contractService;

    private Contract currentContract;

    @PostConstruct
    public void init() {
        mainWindowUserView.getContractsComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (mainWindowUserView.isShown() && e.getStateChange() == ItemEvent.SELECTED) {
                    currentContract = (Contract) e.getItem();
                    updateContractsTab();
                }
            }
        });
        mainWindowUserView.getChangeTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainWindowUserView.getTariffComboBox().setEnabled(true);
            }
        });
        mainWindowUserView.getSaveTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Contract contract = (Contract) mainWindowUserView.getContractsComboBox().getSelectedItem();
                Tariff tariff = (Tariff) mainWindowUserView.getTariffComboBox().getSelectedItem();
                contract.setTariff(tariff);
                contractService.updateContract(contract);

                mainWindowUserView.getTariffComboBox().setEnabled(false);
            }
        });
        mainWindowUserView.getAddOptionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                optionsListView.getOptionsListModel().removeAllElements();
                for (Option option : ((Tariff) mainWindowUserView.getTariffComboBox().getSelectedItem()).getOptions()) {
                    optionsListView.getOptionsListModel().addElement(option);
                }
                optionsListView.getAddButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Contract contract = (Contract) mainWindowUserView.getContractsComboBox().getSelectedItem();
                        contract.getOptions().add((Option) optionsListView.getOptionsList().getSelectedValue());
                        contractService.updateContract(contract);
                        optionsListView.close();
                    }
                });
                optionsListView.show();
            }
        });
        mainWindowUserView.getRemoveOptionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!mainWindowUserView.getOptionsList().isSelectionEmpty()) {
                    Contract contract = (Contract) mainWindowUserView.getContractsComboBox().getSelectedItem();
                    Option option = (Option) mainWindowUserView.getOptionsList().getSelectedValue();
                    contract.getOptions().remove(option);
                    contractService.updateContract(contract);

                    mainWindowUserView.getOptionsListModel().remove(
                            mainWindowUserView.getOptionsList().getSelectedIndex()
                    );
                }
            }
        });

        mainWindowUserView.getEditMyDataButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainWindowUserView.setMyDataEnabled(true);
            }
        });
        mainWindowUserView.getSaveMyDataButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientService.updateClient(getClientFromView());
                String newPassword = mainWindowUserView.getPasswordTextField().getText();
                if (!newPassword.equals("") && !newPassword.equals(authorizationService.getUser().getPassword())) {
                    User user = new User();
                    user.setId(authorizationService.getUser().getId());
                    user.setLogin(authorizationService.getUser().getLogin());
                    user.setPassword(mainWindowUserView.getPasswordTextField().getText());
                    user.setClientId(authorizationService.getUser().getClientId());
                    userService.updateUser(user);
                }
                mainWindowUserView.setMyDataEnabled(false);
            }
        });
    }

    public void initView() {
        initContractsTab();
        initMyDataTab();
    }

    public void initContractsTab() {
        currentContract = clientCache.getClient().getContracts().get(0);
        for (Contract contract : clientCache.getClient().getContracts()) {
            mainWindowUserView.getContractsComboBox().addItem(contract);
        }
        for (Tariff tariff : tariffService.getAllTariffs()) {
            mainWindowUserView.getTariffComboBox().addItem(tariff);
        }
        mainWindowUserView.getTariffComboBox().setSelectedItem(currentContract.getTariff());

        for (Option option : currentContract.getOptions()) {
            mainWindowUserView.getOptionsListModel().addElement(option);
        }
    }

    public void initMyDataTab() {
        mainWindowUserView.getNameTextField().setText(clientCache.getClient().getName());
        mainWindowUserView.getLastNameTextField().setText(clientCache.getClient().getLastname());
        mainWindowUserView.getPassportTextField().setText(clientCache.getClient().getPassport());
        mainWindowUserView.getDateOdBirthTestField().setText(clientCache.getClient().getDateOfBirth());
        mainWindowUserView.getAddressTextField().setText(clientCache.getClient().getAddress());
        mainWindowUserView.getEmailTestField().setText(clientCache.getClient().getEmail());
    }

    private void updateContractsTab() {
        mainWindowUserView.getTariffComboBox().setSelectedItem(currentContract.getTariff());
        mainWindowUserView.getOptionsListModel().removeAllElements();
        for (Option option : currentContract.getOptions()) {
            mainWindowUserView.getOptionsListModel().addElement(option);
        }
    }

    private Client getClientFromView() {
        Client client = new Client();
        client.setId(clientCache.getClient().getId());
        client.setName(mainWindowUserView.getNameTextField().getText());
        client.setLastname(mainWindowUserView.getLastNameTextField().getText());
        client.setPassport(mainWindowUserView.getPassportTextField().getText());
        client.setDateOfBirth(mainWindowUserView.getDateOdBirthTestField().getText());
        client.setAddress(mainWindowUserView.getAddressTextField().getText());
        client.setEmail(mainWindowUserView.getEmailTestField().getText());
        return client;
    }
}
