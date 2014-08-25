package com.github.ilyamurzinov.ecareapp.desktopclient.cache;

import com.github.ilyamurzinov.ecareapp.data.domain.*;
import org.springframework.stereotype.Component;

/**
 * @author ilya-murzinov
 */
@Component
public class Cache {
    private User user = new User();
    private Client client = new Client();
    private Contract contract = new Contract();
    private Tariff tariff = new Tariff();
    private Option option = new Option();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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
