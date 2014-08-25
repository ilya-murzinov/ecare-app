package com.github.ilyamurzinov.ecareapp.desktopclient.controller;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.desktopclient.cache.Cache;
import com.github.ilyamurzinov.ecareapp.desktopclient.service.ClientService;
import com.github.ilyamurzinov.ecareapp.desktopclient.view.ClientPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author ilya-murzinov
 */
@Component
public class ClientController {
    @Autowired
    private ClientPanel clientPanel;

    @Autowired
    private ClientService clientService;

    @Autowired
    private Cache cache;

    @PostConstruct
    public void init() {
        clientPanel.getSaveNewButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Client client = clientPanel.getClientFromView();
                clientService.addClient(client);
            }
        });
        clientPanel.getSaveEditedButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Client client = clientPanel.getClientFromView();
                client.setId(cache.getClient().getId());
                clientService.updateClient(client);
            }
        });
    }
}
