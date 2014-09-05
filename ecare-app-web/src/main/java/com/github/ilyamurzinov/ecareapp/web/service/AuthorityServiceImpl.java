package com.github.ilyamurzinov.ecareapp.web.service;

import com.github.ilyamurzinov.ecareapp.common.domain.Authority;
import com.github.ilyamurzinov.ecareapp.web.dao.AuthorityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilya-murzinov
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityDAO authorityDAO;

    @Override
    public Authority getClientAuthority() {
        return authorityDAO.getAuthority("ROLE_CLIENT");
    }

    @Override
    public Authority getAdminAuthority() {
        return authorityDAO.getAuthority("ROLE_ADMIN");
    }
}
