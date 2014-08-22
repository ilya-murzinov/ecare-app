package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import com.github.ilyamurzinov.ecareapp.desktopclient.controller.MainWindowAdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowAdminView {
    @Autowired
    private MainWindowAdminController controller;

    private JFrame frame;

    private JPanel clientsPanel = new JPanel();
    private JPanel tariffsPanel = new JPanel();
    private JPanel optionsPanel = new JPanel();

    private JScrollPane clientsListBox = new JScrollPane();
    private DefaultListModel clientsListModel = new DefaultListModel();
    private JList clientsList = new JList(clientsListModel);

    private JScrollPane tariffsListBox = new JScrollPane();
    private DefaultListModel tariffsListModel = new DefaultListModel();
    private JList tariffsList = new JList(tariffsListModel);

    private JScrollPane optionsListBox = new JScrollPane();
    private DefaultListModel optionsListModel = new DefaultListModel();
    private JList optionsList = new JList(optionsListModel);

    public MainWindowAdminView() {
        frame = new JFrame("E-Care application");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTabbedPane pane = new JTabbedPane();

        pane.addTab("Clients", clientsPanel);
        pane.addTab("Tariffs", tariffsPanel);
        pane.addTab("Options", optionsPanel);

        initClientsPanel();
        initTariffsPanel();
        initOptionsPanel();

        frame.setContentPane(pane);
    }

    private void initClientsPanel() {
        clientsPanel.setLayout(new BorderLayout());
        clientsListBox.getViewport().add(clientsList);
        clientsPanel.add(clientsListBox);
    }

    private void initTariffsPanel() {
        tariffsPanel.setLayout(new BorderLayout());
        tariffsListBox.getViewport().add(tariffsList);
        tariffsPanel.add(tariffsListBox);
    }

    private void initOptionsPanel() {
        optionsPanel.setLayout(new BorderLayout());
        optionsListBox.getViewport().add(optionsList);
        optionsPanel.add(optionsListBox);
    }

    public void show() {
        controller.initView();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public DefaultListModel getClientsListModel() {
        return clientsListModel;
    }

    public JList getClientsList() {
        return clientsList;
    }

    public DefaultListModel getTariffsListModel() {
        return tariffsListModel;
    }

    public JList getTariffsList() {
        return tariffsList;
    }

    public DefaultListModel getOptionsListModel() {
        return optionsListModel;
    }

    public JList getOptionsList() {
        return optionsList;
    }
}
