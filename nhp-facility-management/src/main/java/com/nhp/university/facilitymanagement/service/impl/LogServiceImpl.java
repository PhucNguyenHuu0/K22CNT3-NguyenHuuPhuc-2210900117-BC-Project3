package com.nhp.university.facilitymanagement.service.impl;

import com.nhp.university.facilitymanagement.model.Log;
import com.nhp.university.facilitymanagement.repository.LogRepository;
import com.nhp.university.facilitymanagement.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void saveLog(Log log) {
        logRepository.save(log);
    }
}