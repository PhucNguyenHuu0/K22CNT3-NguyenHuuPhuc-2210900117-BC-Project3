package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.Log;
import com.nhp.university.facilitymanagement.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    // Lấy danh sách lịch sử hoạt động
    @GetMapping
    public ResponseEntity<List<Log>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }
}
