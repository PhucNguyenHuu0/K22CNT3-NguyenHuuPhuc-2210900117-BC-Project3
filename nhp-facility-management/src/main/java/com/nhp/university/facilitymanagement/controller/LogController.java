package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.Log;
import com.nhp.university.facilitymanagement.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<List<Log>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }

    @PostMapping
    public ResponseEntity<String> saveLog(@RequestParam String action, @RequestParam Long userId, @RequestParam String details) {
        logService.saveLog(action, userId, details);
        return ResponseEntity.ok("Log saved successfully");
    }
}