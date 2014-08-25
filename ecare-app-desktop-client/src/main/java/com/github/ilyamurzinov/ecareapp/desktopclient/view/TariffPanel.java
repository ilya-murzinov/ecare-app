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
public class TariffPanel extends JPanel implements View {
    private JTextField nameTextField = new JTextField();
    private JTextField priceTextField = new JTextField();
    private ListModelDecorator optionsListModel = new ListModelDecorator();
    private JList optionsList = new JList(optionsListModel);
    private JButton addOptionButton = new JButton("Add option");
    private JButton removeOptionButton = new JButton("Remove option");
    private JScrollPane optionsListBox = new JScrollPane();

    private JButton editButton = new JButton("Edit");
    private JButton saveNewTariffButton = new JButton("Save");
    private JButton saveEditedTariffButton = new JButton("Save");
    private JButton cancelButton = new JButton("Cancel");

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

        constraints.gridwidth = 3;
        JScrollPane optionsListBox = new JScrollPane();
        optionsListBox.getViewport().add(optionsList);
        optionsListBox.setPreferredSize(new Dimension(100, 100));

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.ipady = 50;
        layout.setConstraints(optionsListBox, constraints);
        add(optionsListBox);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 1;
        constraints.ipady = 0;
        layout.setConstraints(addOptionButton, constraints);
        add(addOptionButton);

        constraints.gridx++;
        layout.setConstraints(removeOptionButton, constraints);
        add(removeOptionButton);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(editButton, constraints);
        add(editButton);

        constraints.gridx++;
        layout.setConstraints(saveEditedTariffButton, constraints);
        add(saveEditedTariffButton);
        layout.setConstraints(saveNewTariffButton, constraints);
        add(saveNewTariffButton);

        constraints.gridx++;
        layout.setConstraints(cancelButton, constraints);
        add(cancelButton);
    }

    @Override
    public void setEnabled(boolean enabled) {
        nameTextField.setEnabled(enabled);
        priceTextField.setEnabled(enabled);
    }

    @Override
    public void setMode(ViewMode mode) {
        switch (mode) {
            case VIEW:
                setEnabled(false);
                editButton.setVisible(false);
                saveEditedTariffButton.setVisible(false);
                saveNewTariffButton.setVisible(false);
                break;
            case EDIT:
                setEnabled(false);
                editButton.setVisible(true);
                saveEditedTariffButton.setVisible(true);
                saveNewTariffButton.setVisible(false);
                break;
            case ADD:
                setEnabled(true);
                editButton.setVisible(true);
                saveEditedTariffButton.setVisible(false);
                saveNewTariffButton.setVisible(true);
                break;
        }
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

    public JButton getSaveNewTariffButton() {
        return saveNewTariffButton;
    }

    public JButton getSaveEditedTariffButton() {
        return saveEditedTariffButton;
    }
}
