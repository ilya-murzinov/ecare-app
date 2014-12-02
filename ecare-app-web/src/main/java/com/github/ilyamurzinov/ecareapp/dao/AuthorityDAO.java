package com.github.ilyamurzinov.ecareapp.dao;

import com.github.ilyamurzinov.ecareapp.domain.Authority;

/**
 * @author ilya-murzinov
 */
public interface AuthorityDAO {
    Authority getAuthority(String name);
}
