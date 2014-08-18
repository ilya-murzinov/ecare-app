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
    private MainWindowUserController controller;

    private JFrame frame;

    private JPanel contractsPanel;
    private JPanel myDataPanel;

    private JComboBox contractsComboBox;
    private JLabel label1 = new JLabel("Label1");
    private JLabel label2 = new JLabel("Label2");
    private JLabel label3 = new JLabel("Label3");
    private JLabel label4 = new JLabel("Label4");

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

        addContractsPanel();
        addMyDataPanel();

        pane.addTab("My contracts", contractsPanel);
        pane.addTab("My data", myDataPanel);

        frame.getContentPane().add(pane);
    }

    private void addContractsPanel() {
        GridBagLayout layout = new GridBagLayout();
        contractsPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        contractsComboBox = new JComboBox();
        for (String s : controller.getContracts()) {
            contractsComboBox.addItem(s);
        }

        layout.setConstraints(contractsComboBox, constraints);
        contractsPanel.add(contractsComboBox);

        constraints.gridy++;
        layout.setConstraints(label1, constraints);
        contractsPanel.add(label1);

        constraints.gridy++;
        layout.setConstraints(label2, constraints);
        contractsPanel.add(label2);

        constraints.gridy++;
        layout.setConstraints(label3, constraints);
        contractsPanel.add(label3);

        constraints.gridy++;
        layout.setConstraints(label4, constraints);
        contractsPanel.add(label4);
    }

    private void addMyDataPanel() {
        GridBagLayout layout = new GridBagLayout();
        myDataPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);
    }

    public void show() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}
