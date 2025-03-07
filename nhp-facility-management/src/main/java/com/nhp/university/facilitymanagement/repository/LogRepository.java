package com.nhp.university.facilitymanagement.repository;

import com.nhp.university.facilitymanagement.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findAllByOrderByTimestampDesc();
}