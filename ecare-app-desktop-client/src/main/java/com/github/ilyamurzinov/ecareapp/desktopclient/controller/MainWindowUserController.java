package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.data.domain.Contract;
import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.ClientCache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.ClientService;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.MainWindowUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowUserController {
    @Autowired
    private MainWindowUserView mainWindowUserView;

    @Autowired
    private ClientCache clientCache;

    @Autowired
    private ClientService clientService;

    @PostConstruct
    public void init() {
        mainWindowUserView.getEditButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainWindowUserView.setEnabled(true);
            }
        });
        mainWindowUserView.getSaveButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientService.updateClient(getClientFromView());
                mainWindowUserView.setEnabled(false);
            }
        });
    }

    public void updateView() {
        mainWindowUserView.getNameTextField().setText(clientCache.getClient().getName());
        mainWindowUserView.getLastNameTextField().setText(clientCache.getClient().getLastname());
        mainWindowUserView.getPassportTextField().setText(clientCache.getClient().getPassport());
        mainWindowUserView.getDateOdBirthTestField().setText(clientCache.getClient().getDateOfBirth());
        mainWindowUserView.getAddressTextField().setText(clientCache.getClient().getAddress());
        mainWindowUserView.getEmailTestField().setText(clientCache.getClient().getEmail());
        for (Contract contract : clientCache.getClient().getContracts()) {
            mainWindowUserView.getContractsComboBox().addItem(contract.getNumber());
            for (Option option : contract.getOptions()) {
                mainWindowUserView.getOptionsList().addElement(option);
            }
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
