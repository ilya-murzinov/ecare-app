package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Authority;

/**
 * @author ilya-murzinov
 */
public interface AuthorityService {
    Authority getClientAuthority();

    Authority getAdminAuthority();
}
