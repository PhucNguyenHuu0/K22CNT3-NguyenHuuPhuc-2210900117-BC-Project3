package com.nhp.university.facilitymanagement.repository;

import com.nhp.university.facilitymanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}