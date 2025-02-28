package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.MaintenanceRequest;
import com.nhp.university.facilitymanagement.service.MaintenanceRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-requests")
@RequiredArgsConstructor  // Lombok sẽ tự động inject requestService
public class MaintenanceRequestController {

    private final MaintenanceRequestService requestService = null;

    @GetMapping
    public ResponseEntity<List<MaintenanceRequest>> getAllRequests() {
        return ResponseEntity.ok(requestService.getAllRequests());
    }

    @PostMapping
    public ResponseEntity<MaintenanceRequest> createRequest(@RequestBody MaintenanceRequest request) {
        return ResponseEntity.ok(requestService.createRequest(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return ResponseEntity.ok("Request deleted successfully");
    }
}
