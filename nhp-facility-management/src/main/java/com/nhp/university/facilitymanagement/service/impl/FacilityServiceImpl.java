package com.nhp.university.facilitymanagement.service.impl;

import com.nhp.university.facilitymanagement.model.Facility;
import com.nhp.university.facilitymanagement.repository.FacilityRepository;
import com.nhp.university.facilitymanagement.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    @Autowired
    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility saveFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility getFacilityById(Long id) {
        return facilityRepository.findById(id).orElseThrow(() -> new RuntimeException("Facility not found"));
    }

    @Override
    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }
}