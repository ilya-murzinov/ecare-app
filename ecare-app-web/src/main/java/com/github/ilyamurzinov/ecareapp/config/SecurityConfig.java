package com.github.ilyamurzinov.ecareapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;

/**
 * @author ilya-murzinov
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
                .antMatchers("/").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/**").authenticated()
                .and().rememberMe()
                .and().formLogin().defaultSuccessUrl("/", false)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/WEB-INF/views/403.jsp");
    }

    @Bean
    public GlobalMethodSecurityConfiguration getGlobalMethodSecurityConfiguration() {
        GlobalMethodSecurityConfiguration globalMethodSecurityConfiguration = new GlobalMethodSecurityConfiguration();
        globalMethodSecurityConfiguration.setPermissionEvaluator(new ArrayList<PermissionEvaluator>(){{
            add(getPermissionEvaluator());
        }});
        return globalMethodSecurityConfiguration;
    }

    @Bean
    public PermissionEvaluator getPermissionEvaluator() {
        return new EditContractPermissionEvaluator();
    }
}
