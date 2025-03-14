package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.Facility;
import java.util.List;

public interface FacilityService {
    Facility saveFacility(Facility facility);
    List<Facility> getAllFacilities();
    Facility getFacilityById(Long id);
    void deleteFacility(Long id);
}