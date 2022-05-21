package com.recipebook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/recipes/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/recipes/add").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/recipes/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/recipes/**").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}