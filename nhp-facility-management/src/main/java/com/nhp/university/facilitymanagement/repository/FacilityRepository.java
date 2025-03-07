package com.nhp.university.facilitymanagement.repository;

import com.nhp.university.facilitymanagement.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
}