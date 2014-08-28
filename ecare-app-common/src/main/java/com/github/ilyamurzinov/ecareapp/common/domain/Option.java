package com.github.ilyamurzinov.ecareapp.common.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Name must be defined")
    private String name;

    @Column(name = "subscription_fee")
    @NotNull(message = "Subscription fee must be defined")
    private double subscriptionFee;

    @NotNull(message = "Price must be defined")
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
        return String.format("%s, fee - %s, price - %s", name, subscriptionFee, price);
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
