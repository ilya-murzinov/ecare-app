package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.data.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
@Lazy
public class MainWindowUserView {
    private JFrame frame;

    private JPanel contractsPanel;
    private JPanel myDataPanel;

    private JComboBox contractsComboBox;
    private JLabel numberLabel = new JLabel("Number");
    private JLabel tariffLabel = new JLabel("Tariff");

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

        frame.getContentPane().add(pane);
    }

    public void addContractsPanel() {
        GridBagLayout layout = new GridBagLayout();
        contractsPanel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);

        contractsComboBox = new JComboBox();

        layout.setConstraints(contractsComboBox, constraints);
        contractsPanel.add(contractsComboBox);

        constraints.gridy++;
        layout.setConstraints(numberLabel, constraints);
        contractsPanel.add(numberLabel);

        constraints.gridy++;
        layout.setConstraints(tariffLabel, constraints);
        contractsPanel.add(tariffLabel);
    }

    public void addMyDataPanel() {
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

    public JComboBox getContractsComboBox() {
        return contractsComboBox;
    }
}
