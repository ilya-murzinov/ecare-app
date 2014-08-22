package com.github.ilyamurzinov.ecareapp.desktopclient.cache;

import com.github.ilyamurzinov.ecareapp.data.domain.Client;
import com.github.ilyamurzinov.ecareapp.data.domain.Option;
import com.github.ilyamurzinov.ecareapp.data.domain.Tariff;
import org.springframework.stereotype.Component;

/**
 * @author ilya-murzinov
 */
@Component
public class Cache {
    private Client client;
    private Tariff tariff;
    private Option option;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
