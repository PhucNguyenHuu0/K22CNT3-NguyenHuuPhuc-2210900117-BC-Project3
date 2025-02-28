package com.nhp.university.facilitymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
            .password("{noop}admin123") // {noop} để không cần mã hóa password
            .roles("ADMIN")
            .build();

        UserDetails user = User.withUsername("user")
            .password("{noop}user123")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
