package com.github.ilyamurzinov.ecareapp.data;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.data.service.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author ilya-murzinov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:data-spring-сontext.xml"})
public class ClientServiceTest {
    @Autowired
    private ClientService clientService;

    @Test
    public void getClientTest() {
        Client client = clientService.getClient(1);
        int tariffId = client.getContracts().get(0).getTariff().getId();
    }

    @Test
    public void addClientTest() {
        Client client = new Client();
        int size = clientService.getAllClients().size();
        clientService.addClient(client);
        Assert.assertEquals(size + 1, clientService.getAllClients().size());
    }

    @Test
    public void removeClientTest() {
        int size = clientService.getAllClients().size();
        clientService.removeClient(clientService.getAllClients().get(size - 1).getId());
        Assert.assertEquals(size - 1, clientService.getAllClients().size());
    }
}
