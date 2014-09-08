package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author ilya-murzinov
 */
@Component
public class TariffView {
    @Autowired
    private TariffPanel tariffPanel;

    private JFrame frame = new JFrame();

    public TariffView() {
        frame.setTitle("Tariff");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @PostConstruct
    public void init() {
        frame.setContentPane(tariffPanel);
    }

    public void display() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }

    public TariffPanel getTariffPanel() {
        return tariffPanel;
    }
}
