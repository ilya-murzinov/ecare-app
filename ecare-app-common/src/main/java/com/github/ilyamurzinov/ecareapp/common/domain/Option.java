package com.github.ilyamurzinov.ecareapp.common.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "t_option")
public class Option implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name may not be empty")
    private String name;

    @Column(name = "subscription_fee")
    @NotNull(message = "Subscription fee may not be empty")
    private double subscriptionFee;

    @NotNull(message = "Price may not be empty")
    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "required_option",
            joinColumns = @JoinColumn(name = "option1_id"),
            inverseJoinColumns = @JoinColumn(name = "option2_id")
    )
    private Set<Option> requiredOptions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "incompatible_option",
            joinColumns = @JoinColumn(name = "option1_id"),
            inverseJoinColumns = @JoinColumn(name = "option2_id")
    )
    private Set<Option> incompatibleOptions;

    @AssertTrue(message = "Required options can not contain incompatible option and other way around")
    public boolean isValid() {
        for (Option requiredOption : requiredOptions) {
            if (incompatibleOptions.contains(requiredOption)) {
                return false;
            }
        }
        return true;
    }

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

    public Set<Option> getRequiredOptions() {
        return requiredOptions;
    }

    public void setRequiredOptions(Set<Option> requiredOptions) {
        this.requiredOptions = requiredOptions;
    }

    public Set<Option> getIncompatibleOptions() {
        return incompatibleOptions;
    }

    public void setIncompatibleOptions(Set<Option> incompatibleOptions) {
        this.incompatibleOptions = incompatibleOptions;
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
