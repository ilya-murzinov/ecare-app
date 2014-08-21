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
    private JComboBox tariffComboBox = new JComboBox();
    private DefaultListModel optionsListModel = new DefaultListModel();
    private JList optionsList = new JList(optionsListModel);
    private JScrollPane optionsListBox = new JScrollPane();
    private JButton changeTariffButton = new JButton("Change tariff");
    private JButton saveTariffButton = new JButton("Save tariff");
    private JButton addOptionButton = new JButton("Add option");
    private JButton removeOptionButton = new JButton("Remove option");

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
        constraints.gridwidth = 2;

        layout.setConstraints(contractsComboBox, constraints);
        contractsPanel.add(contractsComboBox);

        constraints.gridy++;
        constraints.gridwidth = 1;
        layout.setConstraints(tariffLabel, constraints);
        contractsPanel.add(tariffLabel);

        tariffComboBox.setEnabled(false);

        constraints.gridx++;
        constraints.gridwidth = 1;
        layout.setConstraints(tariffComboBox, constraints);
        contractsPanel.add(tariffComboBox);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(changeTariffButton, constraints);
        contractsPanel.add(changeTariffButton);

        constraints.gridx++;
        layout.setConstraints(saveTariffButton, constraints);
        contractsPanel.add(saveTariffButton);

        constraints.gridwidth = 2;
        optionsListBox.getViewport().add(optionsList);
        optionsListBox.setPreferredSize(new Dimension(100, 100));

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(optionsListBox, constraints);
        contractsPanel.add(optionsListBox);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 1;
        layout.setConstraints(addOptionButton, constraints);
        contractsPanel.add(addOptionButton);

        constraints.gridx++;
        layout.setConstraints(removeOptionButton, constraints);
        contractsPanel.add(removeOptionButton);
    }

    private void initMyDataPanel() {
        GridBagLayout layout = new GridBagLayout();
        myDataPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        setMyDataEnabled(false);

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

    public void setMyDataEnabled(boolean enabled) {
        nameTextField.setEnabled(enabled);
        lastNameTextField.setEnabled(enabled);
        passportTextField.setEnabled(enabled);
        dateOdBirthTestField.setEnabled(enabled);
        addressTextField.setEnabled(enabled);
        emailTestField.setEnabled(enabled);
        passwordTextField.setEnabled(enabled);
    }

    public void show() {
        mainWindowUserController.initView();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public boolean isShown() {
        return frame.isVisible();
    }

    public JComboBox getContractsComboBox() {
        return contractsComboBox;
    }

    public DefaultListModel getOptionsListModel() {
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
