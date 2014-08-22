package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import java.awt.*;

/**
 * @author ilya-murzinov
 */
public class GridBagConstraintsHelper {
    private GridBagConstraintsHelper() {
    }

    public static void init(GridBagConstraints constraints) {
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
    }
}
