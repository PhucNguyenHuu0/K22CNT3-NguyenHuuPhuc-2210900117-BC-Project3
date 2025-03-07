package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.Facility;
import com.nhp.university.facilitymanagement.model.User;
import com.nhp.university.facilitymanagement.repository.FacilityRepository;
import com.nhp.university.facilitymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacilityService {
    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;

    @Autowired
    public FacilityService(FacilityRepository facilityRepository, UserRepository userRepository) {
        this.facilityRepository = facilityRepository;
        this.userRepository = userRepository;
    }

    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Transactional
    public Facility addFacility(Facility facility, Long userId) {
        if (userId != null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            facility.setUser(user);
        }
        return facilityRepository.save(facility);
    }

    @Transactional
    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }
}