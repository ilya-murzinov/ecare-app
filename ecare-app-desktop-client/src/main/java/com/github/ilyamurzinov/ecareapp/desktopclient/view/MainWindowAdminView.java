package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowAdminView {
    private JFrame frame;

    private JPanel clientsPanel = new JPanel();
    private JPanel tariffsPanel = new JPanel();
    private JPanel optionsPanel = new JPanel();

    private JScrollPane clientsListBox = new JScrollPane();
    private DefaultListModel clientsListModel = new DefaultListModel();
    private JList clientsList = new JList(clientsListModel);
    private JButton addClientButton = new JButton("Add client");
    private JButton removeClientButton = new JButton("Remove client");
    private JButton editClientButton = new JButton("Edit client");

    private JScrollPane tariffsListBox = new JScrollPane();
    private DefaultListModel tariffsListModel = new DefaultListModel();
    private JList tariffsList = new JList(tariffsListModel);
    private JButton addTariffButton = new JButton("Add tariff");
    private JButton removeTariffButton = new JButton("Remove tariff");
    private JButton editTariffButton = new JButton("Edit tariff");

    private JScrollPane optionsListBox = new JScrollPane();
    private ListModelDecorator optionsListModel = new ListModelDecorator();
    private JList optionsList = new JList(optionsListModel);
    private JButton addOptionButton = new JButton("Add option");
    private JButton removeOptionButton = new JButton("Remove option");
    private JButton editOptionButton = new JButton("Edit option");

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
        GridBagLayout layout = new GridBagLayout();
        clientsPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        constraints.ipady = 250;
        constraints.gridwidth = 3;
        clientsListBox.getViewport().add(clientsList);
        layout.setConstraints(clientsListBox, constraints);
        clientsPanel.add(clientsListBox);

        constraints.ipady = 0;
        constraints.gridwidth = 1;
        constraints.gridy++;
        layout.setConstraints(editClientButton, constraints);
        clientsPanel.add(editClientButton);

        constraints.gridx++;
        layout.setConstraints(addClientButton, constraints);
        clientsPanel.add(addClientButton);

        constraints.gridx++;
        layout.setConstraints(removeClientButton, constraints);
        clientsPanel.add(removeClientButton);

    }

    private void initTariffsPanel() {
        GridBagLayout layout = new GridBagLayout();
        tariffsPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        constraints.ipady = 250;
        constraints.gridwidth = 3;
        tariffsListBox.getViewport().add(tariffsList);
        layout.setConstraints(tariffsListBox, constraints);
        tariffsPanel.add(tariffsListBox);

        constraints.ipady = 0;
        constraints.gridwidth = 1;
        constraints.gridy++;
        layout.setConstraints(editTariffButton, constraints);
        tariffsPanel.add(editTariffButton);

        constraints.gridx++;
        layout.setConstraints(addTariffButton, constraints);
        tariffsPanel.add(addTariffButton);

        constraints.gridx++;
        layout.setConstraints(removeTariffButton, constraints);
        tariffsPanel.add(removeTariffButton);
    }

    private void initOptionsPanel() {
        GridBagLayout layout = new GridBagLayout();
        optionsPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        constraints.ipady = 250;
        constraints.gridwidth = 3;
        optionsListBox.getViewport().add(optionsList);
        layout.setConstraints(optionsListBox, constraints);
        optionsPanel.add(optionsListBox);

        constraints.ipady = 0;
        constraints.gridwidth = 1;
        constraints.gridy++;
        layout.setConstraints(editOptionButton, constraints);
        optionsPanel.add(editOptionButton);

        constraints.gridx++;
        layout.setConstraints(addOptionButton, constraints);
        optionsPanel.add(addOptionButton);

        constraints.gridx++;
        layout.setConstraints(removeOptionButton, constraints);
        optionsPanel.add(removeOptionButton);
    }

    public void show() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
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

    public ListModelDecorator getOptionsListModel() {
        return optionsListModel;
    }

    public JList getOptionsList() {
        return optionsList;
    }

    public JButton getAddClientButton() {
        return addClientButton;
    }

    public JButton getRemoveClientButton() {
        return removeClientButton;
    }

    public JButton getEditClientButton() {
        return editClientButton;
    }

    public JButton getAddTariffButton() {
        return addTariffButton;
    }

    public JButton getRemoveTariffButton() {
        return removeTariffButton;
    }

    public JButton getEditTariffButton() {
        return editTariffButton;
    }

    public JButton getAddOptionButton() {
        return addOptionButton;
    }

    public JButton getRemoveOptionButton() {
        return removeOptionButton;
    }

    public JButton getEditOptionButton() {
        return editOptionButton;
    }
}
