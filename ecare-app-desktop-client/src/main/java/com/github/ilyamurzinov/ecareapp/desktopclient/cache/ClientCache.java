package com.github.ilyamurzinov.ecareapp.desktopclient.cache;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import org.springframework.stereotype.Component;

/**
 * @author ilya-murzinov
 */
@Component
public class ClientCache {
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
