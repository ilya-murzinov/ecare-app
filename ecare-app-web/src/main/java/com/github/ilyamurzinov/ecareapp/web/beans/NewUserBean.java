package com.github.ilyamurzinov.ecareapp.web.beans;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertTrue;

/**
 * @author ilya-murzinov
 */
public class NewUserBean {
    @NotBlank(message = "Email may not be empty")
    @Email(message = "E-mail must have correct format")
    private String email;

    @NotBlank(message = "Password may not be empty")
    private String password;

    @NotBlank(message = "Password confirmation may not be empty")
    private String passwordRetyped;

    @AssertTrue(message = "Password doesn't match confirmation")
    public boolean isValid() {
        if (password == null || passwordRetyped == null) {
            return false;
        }
        return password.equals(passwordRetyped);
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

    public String getPasswordRetyped() {
        return passwordRetyped;
    }

    public void setPasswordRetyped(String passwordRetyped) {
        this.passwordRetyped = passwordRetyped;
    }
}
