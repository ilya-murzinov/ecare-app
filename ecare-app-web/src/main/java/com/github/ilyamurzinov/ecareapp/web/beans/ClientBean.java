package com.github.ilyamurzinov.ecareapp.web.beans;

import com.github.ilyamurzinov.ecareapp.common.domain.Client;
import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author ilya-murzinov
 */
public class ClientBean {
    @NotBlank
    @Length(max = 32)
    private String name;

    @NotBlank
    @Length(max = 32)
    private String lastname;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past
    private Date dateOfBirth;

    @Length(max = 200)
    private String passport;

    @Length(max = 200)
    private String address;

    @NotBlank
    @Email
    @Length(max = 32)
    private String email;

    @NotBlank
    private String password;

    public ClientBean(Client client, User user) {
        setName(client.getName());
        setLastname(client.getLastname());
        setPassport(client.getPassport());
        setDateOfBirth(client.getDateOfBirth());
        setAddress(client.getAddress());
        setEmail(user.getEmail());
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
