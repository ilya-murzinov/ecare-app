package com.github.ilyamurzinov.ecareapp.data.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "t_option")
public class Option implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column(name = "subscription_fee")
    private double subscriptionFee;

    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        if (id != option.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
