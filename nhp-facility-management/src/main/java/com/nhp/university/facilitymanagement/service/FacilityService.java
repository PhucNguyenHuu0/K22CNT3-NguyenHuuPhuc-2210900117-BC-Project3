package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.Facility;
import com.nhp.university.facilitymanagement.repository.FacilityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final LogService logService;

    @Autowired
    public FacilityService(FacilityRepository facilityRepository, LogService logService) {
        this.facilityRepository = facilityRepository;
        this.logService = logService;
    }

    public Facility addFacility(Facility facility, Long userId) {
        Facility savedFacility = facilityRepository.save(facility);
        logService.saveLog("CREATE_FACILITY", userId, "Added facility: " + facility.getName());
        return savedFacility;
    }
}
