package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
@Component
public class OptionsListView {
    private JFrame frame = new JFrame();

    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private DefaultListModel optionsListModel = new DefaultListModel();
    private JList optionsList = new JList(optionsListModel);
    private JButton addButton = new JButton("Add");

    public OptionsListView() {
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraintsHelper.init(constraints);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridheight = 4;

        scrollPane.getViewport().add(optionsList);
        layout.setConstraints(scrollPane, constraints);
        panel.add(scrollPane);

        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(addButton, constraints);
        panel.add(addButton);

        frame.setContentPane(panel);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    public DefaultListModel getOptionsListModel() {
        return optionsListModel;
    }

    public JList getOptionsList() {
        return optionsList;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
