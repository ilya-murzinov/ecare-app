package com.github.ilyamurzinov.ecareapp.web.config;

import com.github.ilyamurzinov.ecareapp.common.domain.Contract;
import com.github.ilyamurzinov.ecareapp.common.domain.User;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * @author ilya-murzinov
 */
public class EditContractPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o2) {
        if (!(authentication.getPrincipal() instanceof User && o2 instanceof String && o instanceof Integer)) {
            return false;
        }

        User user = (User) authentication.getPrincipal();
        int id = (Integer) o;
        String permission = (String) o2;

        if (permission.equals("edit_contract")) {
            for (Contract contract : user.getClient().getContracts()) {
                if (contract.getId() == id && !(contract.isBlocked() && contract.isBlockedByEmployee())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
