package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author ilya-murzinov
 */
public class DialogView extends JDialog {
    public DialogView(JFrame parent, String title, String message) {
        super(parent, title, true);
        if (parent != null) {
            Dimension parentSize = parent.getSize();
            Point p = parent.getLocation();
            setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
        }
        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel(message));
        getContentPane().add(messagePane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    close();
                }
            }
        });
        pack();
    }

    public void display() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }
}
