package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.Log;
import com.nhp.university.facilitymanagement.service.LogService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @PostMapping
    public ResponseEntity<String> createLog(@RequestParam String action, @RequestParam Long userId, @RequestParam String details) {
        logService.saveLog(action, userId, details);
        return ResponseEntity.ok("Log created successfully");
    }
}
