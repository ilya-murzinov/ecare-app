package com.github.ilyamurzinov.ecareapp.web.dao;

import com.github.ilyamurzinov.ecareapp.common.domain.Authority;

/**
 * @author ilya-murzinov
 */
public interface AuthorityDAO {
    Authority getAuthority(String name);
}
