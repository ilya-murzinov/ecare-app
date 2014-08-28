package com.github.ilyamurzinov.ecareapp.web.beans;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.User;

import java.util.Date;

/**
 * @author ilya-murzinov
 */
public class ClientBean {
    private int id;
    private String name;
    private String lastname;
    private Date dateOfBirth;
    private String passport;
    private String address;
    private String email;
    private String password;

    public ClientBean(Client client, User user) {
        setName(client.getName());
        setLastname(client.getLastname());
        setPassport(client.getPassport());
        setDateOfBirth(client.getDateOfBirth());
        setAddress(client.getAddress());
        setEmail(user.getEmail());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
