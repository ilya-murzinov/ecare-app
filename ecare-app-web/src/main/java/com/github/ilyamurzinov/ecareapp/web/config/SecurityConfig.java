package com.github.ilyamurzinov.ecareapp.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

/**
 * @author ilya-murzinov
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new Md5PasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/change-password/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
                .antMatchers("/contract/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
                .antMatchers("/client/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
                .antMatchers("/backoffice/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/clientoffice/**").access("hasRole('ROLE_CLIENT')")
                .and().formLogin().defaultSuccessUrl("/", false)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/WEB-INF/views/403.jsp");;
    }
}
