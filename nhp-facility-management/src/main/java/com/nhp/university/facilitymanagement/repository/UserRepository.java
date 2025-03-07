package com.nhp.university.facilitymanagement.repository;

import com.nhp.university.facilitymanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
