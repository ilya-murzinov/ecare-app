package com.github.ilyamurzinov.ecareapp.web.beans;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 * @author ilya-murzinov
 */
public class PasswordBean {
    @NotBlank
    private String currentPassword;

    @NotBlank
    @Size(min = 6, max = 20)
    private String newPassword;

    @NotBlank
    private String newPasswordRetyped;

    @AssertTrue
    private boolean isValid() {
        return newPassword.equals(newPasswordRetyped);
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordRetyped() {
        return newPasswordRetyped;
    }

    public void setNewPasswordRetyped(String newPasswordRetyped) {
        this.newPasswordRetyped = newPasswordRetyped;
    }
}
