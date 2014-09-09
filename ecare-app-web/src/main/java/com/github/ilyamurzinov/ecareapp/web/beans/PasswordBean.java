package com.github.ilyamurzinov.ecareapp.web.beans;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 * @author ilya-murzinov
 */
public class PasswordBean {
    @NotBlank(message = "Current password may not be empty")
    private String currentPassword;

    @NotBlank(message = "New password may not be empty")
    @Size(min = 4, max = 20, message = "New password must be between 4 and 20 symbols")
    private String newPassword;

    @NotBlank(message = "New password may not be empty")
    private String newPasswordRetyped;

    private boolean valid;

    @AssertTrue(message = "New passwords don't match")
    public boolean isValid() {
        valid = newPassword != null && newPasswordRetyped != null && newPassword.equals(newPasswordRetyped);
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
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
