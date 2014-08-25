package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
public class ContractPanel extends JPanel {
    private JComboBox contractsComboBox = new JComboBox();
    private JComboBox tariffComboBox = new JComboBox();
    private ListModelDecorator optionsListModel = new ListModelDecorator();
    private JList optionsList = new JList(optionsListModel);
    private JButton changeTariffButton = new JButton("Change tariff");
    private JButton saveTariffButton = new JButton("Save tariff");
    private JButton addOptionButton = new JButton("Add option");
    private JButton removeOptionButton = new JButton("Remove option");

    public ContractPanel() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);
        constraints.gridwidth = 2;

        layout.setConstraints(contractsComboBox, constraints);
        add(contractsComboBox);

        constraints.gridy++;
        constraints.gridwidth = 1;
        JLabel tariffLabel = new JLabel("Tariff");
        layout.setConstraints(tariffLabel, constraints);
        add(tariffLabel);

        constraints.gridx++;
        constraints.gridwidth = 1;
        layout.setConstraints(tariffComboBox, constraints);
        add(tariffComboBox);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(changeTariffButton, constraints);
        add(changeTariffButton);

        constraints.gridx++;
        layout.setConstraints(saveTariffButton, constraints);
        add(saveTariffButton);

        constraints.gridwidth = 2;
        JScrollPane optionsListBox = new JScrollPane();
        optionsListBox.getViewport().add(optionsList);
        optionsListBox.setPreferredSize(new Dimension(100, 100));

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(optionsListBox, constraints);
        add(optionsListBox);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 1;
        layout.setConstraints(addOptionButton, constraints);
        add(addOptionButton);

        constraints.gridx++;
        layout.setConstraints(removeOptionButton, constraints);
        add(removeOptionButton);
    }

    public JComboBox getContractsComboBox() {
        return contractsComboBox;
    }

    public ListModelDecorator getOptionsListModel() {
        return optionsListModel;
    }

    public JList getOptionsList() {
        return optionsList;
    }

    public JComboBox getTariffComboBox() {
        return tariffComboBox;
    }

    public JButton getChangeTariffButton() {
        return changeTariffButton;
    }

    public JButton getSaveTariffButton() {
        return saveTariffButton;
    }

    public JButton getAddOptionButton() {
        return addOptionButton;
    }

    public JButton getRemoveOptionButton() {
        return removeOptionButton;
    }
}
