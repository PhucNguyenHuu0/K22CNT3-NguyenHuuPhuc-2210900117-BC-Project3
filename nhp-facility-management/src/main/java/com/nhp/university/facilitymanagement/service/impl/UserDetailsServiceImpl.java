package com.nhp.university.facilitymanagement.service.impl;

import com.nhp.university.facilitymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository NHPUserRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository NHPUserRepository) {
        this.NHPUserRepository = NHPUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String NHPUsername) throws UsernameNotFoundException {
        return NHPUserRepository.findByNHPUsername(NHPUsername)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + NHPUsername));
    }
}