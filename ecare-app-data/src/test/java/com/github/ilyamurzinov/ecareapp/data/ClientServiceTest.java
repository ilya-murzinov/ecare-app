package com.github.ilyamurzinov.ecareapp.data;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.data.service.ClientService;
import com.github.ilyamurzinov.ecareapp.data.service.TariffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ilya-murzinov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-сontext.xml"})
public class ClientServiceTest {
    @Autowired
    private ClientService clientService;

    @Autowired
    private TariffService tariffService;

    @Test
    public void getClientTest() {
        Client client = clientService.getClient(1);
        int tariffId = client.getContracts().get(0).getTariff().getId();
        tariffService.addOption(tariffId, 1);
        client = clientService.getClient(1);
        System.out.println(client);
    }
}
