package com.nhp.university.facilitymanagement.config;

import com.nhp.university.facilitymanagement.model.Location;
import com.nhp.university.facilitymanagement.model.User;
import com.nhp.university.facilitymanagement.repository.LocationRepository;
import com.nhp.university.facilitymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRepository userRepository, LocationRepository locationRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setName("Admin User");
            admin.setEmail("admin@example.com");
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);
        }

        if (locationRepository.count() == 0) {
            Location location = new Location();
            location.setName("Main Campus");
            location.setAddress("123 University Ave");
            locationRepository.save(location);
        }
    }
}
