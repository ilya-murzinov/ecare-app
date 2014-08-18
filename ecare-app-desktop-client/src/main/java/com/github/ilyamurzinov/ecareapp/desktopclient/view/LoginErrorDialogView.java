package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author ilya-murzinov
 */
public class LoginErrorDialogView extends JDialog {
    public LoginErrorDialogView(JFrame parent, String title, String message) {
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
        pack();
    }

    public void display() {
        setVisible(true);
    }
}
