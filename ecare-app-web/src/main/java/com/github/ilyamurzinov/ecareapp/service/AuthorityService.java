package com.github.ilyamurzinov.ecareapp.service;

import com.github.ilyamurzinov.ecareapp.domain.Authority;

/**
 * @author ilya-murzinov
 */
public interface AuthorityService {
    Authority getClientAuthority();

    Authority getAdminAuthority();
}
