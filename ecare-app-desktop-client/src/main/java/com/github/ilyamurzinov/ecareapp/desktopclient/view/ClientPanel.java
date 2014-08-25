package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
@Scope("prototype")
public class ClientPanel extends JPanel implements View {
    private JTextField nameTextField = new JTextField();
    private JTextField lastNameTextField = new JTextField();
    private JTextField passportTextField = new JTextField();
    private JTextField dateOdBirthTestField = new JTextField();
    private JTextField addressTextField = new JTextField();
    private JTextField emailTestField = new JTextField();
    private JTextField passwordTextField = new JTextField();
    private JButton saveNewButton = new JButton("Save");
    private JButton saveEditedButton = new JButton("Save");
    private JButton cancelButton = new JButton("Cancel");

    public ClientPanel() {
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
        layout.setConstraints(saveNewButton, constraints);
        add(saveNewButton);
        layout.setConstraints(saveEditedButton, constraints);
        add(saveEditedButton);

        constraints.gridx++;
        layout.setConstraints(cancelButton, constraints);
        add(cancelButton);
    }

    @Override
    public void setMode(ViewMode mode) {
        switch (mode) {
            case VIEW:
                setEnabled(false);
                saveNewButton.setVisible(false);
                saveEditedButton.setVisible(false);
                break;
            case EDIT:
                setEnabled(true);
                saveNewButton.setVisible(false);
                saveEditedButton.setVisible(true);
                break;
            case ADD:
                setEnabled(true);
                saveNewButton.setVisible(true);
                saveEditedButton.setVisible(false);
                break;
        }
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

    public synchronized JButton getSaveNewButton() {
        return saveNewButton;
    }

    public JButton getSaveEditedButton() {
        return saveEditedButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public Client getClientFromView() {
        Client client = new Client();
        client.setName(getNameTextField().getText());
        client.setLastname(getLastNameTextField().getText());
        client.setPassport(getPassportTextField().getText());
        client.setDateOfBirth(getDateOdBirthTestField().getText());
        client.setAddress(getAddressTextField().getText());
        client.setEmail(getEmailTestField().getText());
        return client;
    }

    public void update(Client client) {
        getNameTextField().setText(client.getName());
        getLastNameTextField().setText(client.getLastname());
        getPassportTextField().setText(client.getPassport());
        getDateOdBirthTestField().setText(client.getDateOfBirth());
        getAddressTextField().setText(client.getAddress());
        getEmailTestField().setText(client.getEmail());
    }
}
