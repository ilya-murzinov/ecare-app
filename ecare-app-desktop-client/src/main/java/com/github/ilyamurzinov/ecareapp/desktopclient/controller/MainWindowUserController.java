package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.data.domain.*;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.Cache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.*;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowUserController {
    @Autowired
    private MainWindowUserView mainWindowUserView;

    @Autowired
    private ContractPanel contractPanel;

    @Autowired
    private ClientPanel clientPanel;

    @Autowired
    private OptionsListView optionsListView;

    @Autowired
    private Cache cache;

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
        mainWindowUserView.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                initView();
            }
        });
        contractPanel.getContractsComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    currentContract = (Contract) e.getItem();
                    updateContractsTab();
                }
            }
        });
        contractPanel.getChangeTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contractPanel.getTariffComboBox().setEnabled(true);
            }
        });
        contractPanel.getSaveTariffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Contract contract = (Contract) contractPanel.getContractsComboBox().getSelectedItem();
                Tariff tariff = (Tariff) contractPanel.getTariffComboBox().getSelectedItem();
                contract.setTariff(tariff);
                contract.setOptions(new ArrayList<Option>());
                contractService.updateContract(contract);

                contractPanel.getTariffComboBox().setEnabled(false);
                updateContractsTab();
            }
        });
        contractPanel.getAddOptionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                optionsListView.getOptionsListModel().removeAllElements();
                for (Option option : ((Tariff) contractPanel.getTariffComboBox().getSelectedItem()).getOptions()) {
                    optionsListView.getOptionsListModel().addElement(option);
                }
                optionsListView.getAddButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Contract contract = (Contract) contractPanel.getContractsComboBox().getSelectedItem();
                        Option option = (Option) optionsListView.getOptionsList().getSelectedValue();
                        if (currentContract.getOptions().contains(option)) {
                            new DialogView(
                                    optionsListView.getFrame(),
                                    "Error",
                                    "You already have this option in this contract"
                            ).display();
                            return;
                        } else {
                            contract.getOptions().add(option);
                        }
                        contractService.updateContract(contract);
                        updateContractsTab();
                        optionsListView.close();
                    }
                });
                optionsListView.display();
            }
        });
        contractPanel.getRemoveOptionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!contractPanel.getOptionsList().isSelectionEmpty()) {
                    Contract contract = (Contract) contractPanel.getContractsComboBox().getSelectedItem();
                    Option option = (Option) contractPanel.getOptionsList().getSelectedValue();
                    contract.getOptions().remove(option);
                    contractService.updateContract(contract);

                    contractPanel.getOptionsListModel().remove(
                            contractPanel.getOptionsList().getSelectedIndex()
                    );
                }
            }
        });

        clientPanel.getEditMyDataButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientPanel.setEnabled(true);
            }
        });
        clientPanel.getSaveMyDataButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientService.updateClient(getClientFromView());
                String newPassword = clientPanel.getPasswordTextField().getText();
                if (!newPassword.equals("") && !newPassword.equals(authorizationService.getUser().getPassword())) {
                    User user = new User();
                    user.setId(authorizationService.getUser().getId());
                    user.setLogin(authorizationService.getUser().getLogin());
                    user.setPassword(clientPanel.getPasswordTextField().getText());
                    user.setClientId(authorizationService.getUser().getClientId());
                    userService.updateUser(user);
                }
                clientPanel.setEnabled(false);
            }
        });
    }

    public void initView() {
        initContractsTab();
        initMyDataTab();
    }

    public void initContractsTab() {
        currentContract = cache.getClient().getContracts().get(0);
        for (Contract contract : cache.getClient().getContracts()) {
            contractPanel.getContractsComboBox().addItem(contract);
        }
        for (Tariff tariff : tariffService.getAllTariffs()) {
            contractPanel.getTariffComboBox().addItem(tariff);
        }
        contractPanel.getTariffComboBox().setSelectedItem(currentContract.getTariff());

        for (Option option : currentContract.getOptions()) {
            contractPanel.getOptionsListModel().addElement(option);
        }
    }

    public void initMyDataTab() {
        clientPanel.getNameTextField().setText(cache.getClient().getName());
        clientPanel.getLastNameTextField().setText(cache.getClient().getLastname());
        clientPanel.getPassportTextField().setText(cache.getClient().getPassport());
        clientPanel.getDateOdBirthTestField().setText(cache.getClient().getDateOfBirth());
        clientPanel.getAddressTextField().setText(cache.getClient().getAddress());
        clientPanel.getEmailTestField().setText(cache.getClient().getEmail());
    }

    private void updateContractsTab() {
        contractPanel.getTariffComboBox().setSelectedItem(currentContract.getTariff());
        contractPanel.getOptionsListModel().removeAllElements();
        for (Option option : currentContract.getOptions()) {
            contractPanel.getOptionsListModel().addElement(option);
        }
    }

    private Client getClientFromView() {
        Client client = new Client();
        client.setId(cache.getClient().getId());
        client.setName(clientPanel.getNameTextField().getText());
        client.setLastname(clientPanel.getLastNameTextField().getText());
        client.setPassport(clientPanel.getPassportTextField().getText());
        client.setDateOfBirth(clientPanel.getDateOdBirthTestField().getText());
        client.setAddress(clientPanel.getAddressTextField().getText());
        client.setEmail(clientPanel.getEmailTestField().getText());
        return client;
    }
}
