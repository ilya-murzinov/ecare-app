package com.github.ilyamurzinov.ecareapp.data.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "contract")
public class Contract implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private int number;

    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
