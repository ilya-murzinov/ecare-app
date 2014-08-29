package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;

/**
 * @author ilya-murzinov
 */
public interface ClientService {
    Client getCurrentClient();
    Client getClient(int id);
    void updateClient(Client client);
}
