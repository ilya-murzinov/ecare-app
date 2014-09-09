package com.github.ilyamurzinov.ecareapp.common.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author ilya-murzinov
 */
@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "E-mail may not be empty")
    @Email(message = "E-mail must have correct format")
    @Length(max = 32)
    private String email;

    @NotBlank(message = "Password may not be empty")
    private String password;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Authority.class)
    @JoinTable(
            name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Collection<GrantedAuthority> authorities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String login) {
        this.email = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            authorities = new HashSet<GrantedAuthority>();
        }
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
