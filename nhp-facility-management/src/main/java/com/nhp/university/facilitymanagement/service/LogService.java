package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.Log;
import com.nhp.university.facilitymanagement.repository.LogRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void saveLog(String action, Long userId, String details) {
        Log log = new Log();
        log.setAction(action);
        log.setUserId(userId);
        log.setDetails(details);
        log.setTimestamp(LocalDateTime.now());
        logRepository.save(log);
    }
}
