package com.github.ilyamurzinov.ecareapp.data.domain;

import javax.persistence.*;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "t_option")
public class Option {
    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column(name = "subscription_fee")
    private double subscriptionFee;

    @Column
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
}
