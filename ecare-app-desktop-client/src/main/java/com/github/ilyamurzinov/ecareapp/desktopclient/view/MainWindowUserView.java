package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import com.github.ilyamurzinov.ecareapp.desktopclient.controller.MainWindowUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowUserView {
    @Autowired
    private ClientPanel clientPanel;

    @Autowired
    private ContractPanel contractPanel;

    @Autowired
    private MainWindowUserController controller;

    private JFrame frame;

    public MainWindowUserView() {
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
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @PostConstruct
    private void init() {
        JTabbedPane pane = new JTabbedPane();

        frame.setContentPane(pane);

        clientPanel.setMode(ViewMode.EDIT);

        pane.addTab("My contracts", contractPanel);
        pane.addTab("My data", clientPanel);
    }

    public void display() {
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

    public ContractPanel getContractPanel() {
        return contractPanel;
    }

    public ClientPanel getClientPanel() {
        return clientPanel;
    }
}
