package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
@Scope("prototype")
public class TariffPanel extends JPanel {
    private JTextField nameTextField = new JTextField();
    private JTextField priceTextField = new JTextField();
    private ListModelDecorator optionsListModel = new ListModelDecorator();
    private JList optionsList = new JList(optionsListModel);
    private JButton addOptionButton = new JButton("Add option");
    private JButton removeOptionButton = new JButton("Remove option");
    private JScrollPane optionsListBox = new JScrollPane();

    private JButton saveButton = new JButton("Save");

    public TariffPanel() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        JLabel nameLabel = new JLabel("Name");
        layout.setConstraints(nameLabel, constraints);
        add(nameLabel);

        constraints.gridx++;
        layout.setConstraints(nameTextField, constraints);
        add(nameTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        JLabel priceLabel = new JLabel("Price");
        layout.setConstraints(priceLabel, constraints);
        add(priceLabel);

        constraints.gridx++;
        layout.setConstraints(priceTextField, constraints);
        add(priceTextField);

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

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(saveButton, constraints);
        add(saveButton);
    }

    @Override
    public void setEnabled(boolean enabled) {
        nameTextField.setEnabled(enabled);
        priceTextField.setEnabled(enabled);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public ListModelDecorator getOptionsListModel() {
        return optionsListModel;
    }

    public JButton getAddOptionButton() {
        return addOptionButton;
    }

    public JButton getRemoveOptionButton() {
        return removeOptionButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
