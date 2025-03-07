package com.nhp.university.facilitymanagement.repository;

import com.nhp.university.facilitymanagement.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
