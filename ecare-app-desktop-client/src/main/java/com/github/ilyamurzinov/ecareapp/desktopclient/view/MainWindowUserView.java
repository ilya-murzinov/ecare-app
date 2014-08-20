package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import com.github.ilyamurzinov.ecareapp.desktopclient.controller.MainWindowUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowUserView {
    @Autowired
    private MainWindowUserController mainWindowUserController;

    private JFrame frame;

    private JPanel contractsPanel;
    private JPanel myDataPanel;

    private JComboBox contractsComboBox = new JComboBox();
    private JLabel tariffLabel = new JLabel("Tariff");
    private DefaultListModel optionsList = new DefaultListModel();
    private JList optionsListBox = new JList(optionsList);

    private JLabel nameLabel = new JLabel("Name");
    private JLabel lastNameLabel = new JLabel("Last name");
    private JLabel passportLabel = new JLabel("Passport");
    private JLabel dateOdBirthLabel = new JLabel("Date of birth");
    private JLabel addressLabel = new JLabel("Address");
    private JLabel emailLabel = new JLabel("E-mail");
    private JLabel passwordLabel = new JLabel("Password");

    private JTextField nameTextField = new JTextField();
    private JTextField lastNameTextField = new JTextField();
    private JTextField passportTextField = new JTextField();
    private JTextField dateOdBirthTestField = new JTextField();
    private JTextField addressTextField = new JTextField();
    private JTextField emailTestField = new JTextField();
    private JTextField passwordTextField = new JTextField();
    private JButton editButton = new JButton("Edit");
    private JButton saveButton = new JButton("Save");

    @PostConstruct
    public void init() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        frame = new JFrame("E-Care application");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTabbedPane pane = new JTabbedPane();

        contractsPanel = new JPanel();
        myDataPanel = new JPanel();

        pane.addTab("My contracts", contractsPanel);
        pane.addTab("My data", myDataPanel);

        initContractsPanel();
        initMyDataPanel();

        frame.getContentPane().add(pane);
    }

    private void initContractsPanel() {
        GridBagLayout layout = new GridBagLayout();
        contractsPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        layout.setConstraints(contractsComboBox, constraints);
        contractsPanel.add(contractsComboBox);

        layout.setConstraints(tariffLabel, constraints);
        contractsPanel.add(tariffLabel);

        constraints.gridy++;
        layout.setConstraints(optionsListBox, constraints);
        contractsPanel.add(optionsListBox);
    }

    private void initMyDataPanel() {
        GridBagLayout layout = new GridBagLayout();
        myDataPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        setEnabled(false);

        layout.setConstraints(nameLabel, constraints);
        myDataPanel.add(nameLabel);

        constraints.gridx++;
        layout.setConstraints(nameTextField, constraints);
        myDataPanel.add(nameTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(lastNameLabel, constraints);
        myDataPanel.add(lastNameLabel);

        constraints.gridx++;
        layout.setConstraints(lastNameTextField, constraints);
        myDataPanel.add(lastNameTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(passportLabel, constraints);
        myDataPanel.add(passportLabel);

        constraints.gridx++;
        layout.setConstraints(passportTextField, constraints);
        myDataPanel.add(passportTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(dateOdBirthLabel, constraints);
        myDataPanel.add(dateOdBirthLabel);

        constraints.gridx++;
        layout.setConstraints(dateOdBirthTestField, constraints);
        myDataPanel.add(dateOdBirthTestField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(addressLabel, constraints);
        myDataPanel.add(addressLabel);

        constraints.gridx++;
        layout.setConstraints(addressTextField, constraints);
        myDataPanel.add(addressTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(emailLabel, constraints);
        myDataPanel.add(emailLabel);

        constraints.gridx++;
        layout.setConstraints(emailTestField, constraints);
        myDataPanel.add(emailTestField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(passwordLabel, constraints);
        myDataPanel.add(passwordLabel);

        constraints.gridx++;
        layout.setConstraints(passwordTextField, constraints);
        myDataPanel.add(passwordTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(editButton, constraints);
        myDataPanel.add(editButton);

        constraints.gridx++;
        layout.setConstraints(saveButton, constraints);
        myDataPanel.add(saveButton);
    }

    public void setEnabled(boolean enabled) {
        nameTextField.setEnabled(enabled);
        lastNameTextField.setEnabled(enabled);
        passportTextField.setEnabled(enabled);
        dateOdBirthTestField.setEnabled(enabled);
        addressTextField.setEnabled(enabled);
        emailTestField.setEnabled(enabled);
        passwordTextField.setEnabled(enabled);
    }

    public void show() {
        mainWindowUserController.updateView();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public JComboBox getContractsComboBox() {
        return contractsComboBox;
    }

    public DefaultListModel getOptionsList() {
        return optionsList;
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

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getEditButton() {
        return editButton;
    }
}
