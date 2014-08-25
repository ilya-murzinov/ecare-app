package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import com.github.ilyamurzinov.ecareapp.desktopclient.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author ilya-murzinov
 */
@Component
public class ClientView {
    @Autowired
    private ClientPanel clientPanel;

    @Autowired
    private Cache cache;

    private JFrame frame = new JFrame();

    public ClientView() {
        frame.setTitle("Client");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @PostConstruct
    private void init() {
        frame.setContentPane(clientPanel);
    }

    public void display() {
        frame.setVisible(true);
    }

    public ClientPanel getClientPanel() {
        return clientPanel;
    }

    public void close() {
        frame.setVisible(false);
    }
}
