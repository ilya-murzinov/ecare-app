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
public class ClientPanel extends JPanel {
    private JTextField nameTextField = new JTextField();
    private JTextField lastNameTextField = new JTextField();
    private JTextField passportTextField = new JTextField();
    private JTextField dateOdBirthTestField = new JTextField();
    private JTextField addressTextField = new JTextField();
    private JTextField emailTestField = new JTextField();
    private JTextField passwordTextField = new JTextField();
    private JButton editButton = new JButton("Edit");
    private JButton saveButton = new JButton("Save");

    public ClientPanel() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        setEnabled(false);

        JLabel nameLabel = new JLabel("Name");
        layout.setConstraints(nameLabel, constraints);
        add(nameLabel);

        constraints.gridx++;
        layout.setConstraints(nameTextField, constraints);
        add(nameTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        JLabel lastNameLabel = new JLabel("Last name");
        layout.setConstraints(lastNameLabel, constraints);
        add(lastNameLabel);

        constraints.gridx++;
        layout.setConstraints(lastNameTextField, constraints);
        add(lastNameTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        JLabel passportLabel = new JLabel("Passport");
        layout.setConstraints(passportLabel, constraints);
        add(passportLabel);

        constraints.gridx++;
        layout.setConstraints(passportTextField, constraints);
        add(passportTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        JLabel dateOdBirthLabel = new JLabel("Date of birth");
        layout.setConstraints(dateOdBirthLabel, constraints);
        add(dateOdBirthLabel);

        constraints.gridx++;
        layout.setConstraints(dateOdBirthTestField, constraints);
        add(dateOdBirthTestField);

        constraints.gridx = 0;
        constraints.gridy++;
        JLabel addressLabel = new JLabel("Address");
        layout.setConstraints(addressLabel, constraints);
        add(addressLabel);

        constraints.gridx++;
        layout.setConstraints(addressTextField, constraints);
        add(addressTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        JLabel emailLabel = new JLabel("E-mail");
        layout.setConstraints(emailLabel, constraints);
        add(emailLabel);

        constraints.gridx++;
        layout.setConstraints(emailTestField, constraints);
        add(emailTestField);

        constraints.gridx = 0;
        constraints.gridy++;
        JLabel passwordLabel = new JLabel("Password");
        layout.setConstraints(passwordLabel, constraints);
        add(passwordLabel);

        constraints.gridx++;
        layout.setConstraints(passwordTextField, constraints);
        add(passwordTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(editButton, constraints);
        add(editButton);

        constraints.gridx++;
        layout.setConstraints(saveButton, constraints);
        add(saveButton);
    }

    @Override
    public void setEnabled(boolean enabled) {
        nameTextField.setEnabled(enabled);
        lastNameTextField.setEnabled(enabled);
        passportTextField.setEnabled(enabled);
        dateOdBirthTestField.setEnabled(enabled);
        addressTextField.setEnabled(enabled);
        emailTestField.setEnabled(enabled);
        passwordTextField.setEnabled(enabled);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public JTextField getPassportTextField() {
        return passportTextField;
    }

    public JTextField getDateOdBirthTestField() {
        return dateOdBirthTestField;
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    public JTextField getEmailTestField() {
        return emailTestField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public JButton getSaveMyDataButton() {
        return saveButton;
    }

    public JButton getEditMyDataButton() {
        return editButton;
    }
}
