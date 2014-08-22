package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
public class LoginWindowView {
    private JFrame frame;

    private JLabel loginTextArea;
    private JTextField loginTextField;

    private JLabel passwordTextArea;
    private JTextField passwordTextField;

    private JButton loginButton;

    @PostConstruct
    public void init() {
        frame = new JFrame("Login to E-Care app");
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loginTextArea = new JLabel("Login");
        loginTextField = new JTextField(20);
        passwordTextArea = new JLabel("Password");
        passwordTextField = new JTextField(20);
        loginButton = new JButton("Login");

        setLayout();
    }

    private void setLayout() {
        JPanel mainPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();

        GridBagConstraintsHelper.init(constraints);

        layout.setConstraints(loginTextArea, constraints);
        mainPanel.add(loginTextArea);

        constraints.gridx++;
        layout.setConstraints(loginTextField, constraints);
        mainPanel.add(loginTextField);

        constraints.gridx = 0;
        constraints.gridy++;
        layout.setConstraints(passwordTextArea, constraints);
        mainPanel.add(passwordTextArea);

        constraints.gridx++;
        layout.setConstraints(passwordTextField, constraints);
        mainPanel.add(passwordTextField);

        constraints.gridy++;
        layout.setConstraints(loginButton, constraints);
        mainPanel.add(loginButton);

        frame.getContentPane().add(mainPanel);
    }

    public void show() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public void close() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(false);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getLoginTextField() {
        return loginTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
