package com.github.ilyamurzinov.ecareapp.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "tariff")
public class Tariff implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private double price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "tariff_option",
            joinColumns = @JoinColumn(name = "tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private Set<Option> options;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tariff tariff = (Tariff) o;

        if (id != tariff.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
