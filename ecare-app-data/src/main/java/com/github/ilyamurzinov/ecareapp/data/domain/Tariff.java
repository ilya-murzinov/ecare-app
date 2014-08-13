package com.github.ilyamurzinov.ecareapp.data.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "tariff")
public class Tariff {
    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
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
}
