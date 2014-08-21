package com.github.ilyamurzinov.ecareapp.data.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String login;

    private String password;

    @Column(name = "client_id")
    private int clientId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
