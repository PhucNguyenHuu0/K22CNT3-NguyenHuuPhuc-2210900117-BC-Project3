package com.nhp.university.facilitymanagement.config;

import com.nhp.university.facilitymanagement.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsServiceImpl NHPUserDetailsService;

    public SecurityConfig(UserDetailsServiceImpl NHPUserDetailsService) {
        this.NHPUserDetailsService = NHPUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity NHPHttp) throws Exception {
        NHPHttp
            .authorizeHttpRequests(NHPAuth -> NHPAuth
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/login", "/error", "/").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(NHPForm -> NHPForm
                .loginPage("/login")
                .permitAll()
            )
            .logout(NHPLogout -> NHPLogout.permitAll());
        return NHPHttp.build();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration NHPConfig) throws Exception {
        return NHPConfig.getAuthenticationManager();
    }
}