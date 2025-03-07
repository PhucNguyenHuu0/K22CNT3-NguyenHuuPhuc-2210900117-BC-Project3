package com.nhp.university.facilitymanagement.repository;

import com.nhp.university.facilitymanagement.model.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
}