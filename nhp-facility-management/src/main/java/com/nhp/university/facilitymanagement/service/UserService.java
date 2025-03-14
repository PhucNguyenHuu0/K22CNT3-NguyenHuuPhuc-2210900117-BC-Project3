package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.User;
import com.nhp.university.facilitymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Tìm người dùng theo email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
