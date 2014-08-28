package com.github.ilyamurzinov.ecareapp.common.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank
    @Length(max = 32)
    private String name;

    @Column(name = "lastname")
    @NotNull
    @NotBlank
    @Length(max = 32)
    private String lastname;

    @Column(name = "date_of_birth")
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past
    private Date dateOfBirth;

    @Length(max = 200)
    private String passport;

    @Length(max = 200)
    private String address;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", lastname, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
