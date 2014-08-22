package com.github.ilyamurzinov.ecareapp.desktopclient.view;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ilya-murzinov
 */
public class ListModelDecorator extends DefaultListModel {
    @SuppressWarnings("unchecked")
    public Set getAllItems() {
        Set set = new HashSet();
        for (int i = 0; i < getSize(); i++) {
            set.add(get(i));
        }
        return set;
    }
}
