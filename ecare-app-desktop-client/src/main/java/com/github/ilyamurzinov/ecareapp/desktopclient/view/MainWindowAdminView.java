package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author ilya-murzinov
 */
@Component
public class MainWindowAdminView {
    private JFrame frame;

    @PostConstruct
    public void init() {
        frame = new JFrame("E-Care application");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
