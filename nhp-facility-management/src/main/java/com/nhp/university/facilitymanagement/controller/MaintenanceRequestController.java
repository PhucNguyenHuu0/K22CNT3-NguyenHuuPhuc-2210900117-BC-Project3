package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.MaintenanceRequest;
import com.nhp.university.facilitymanagement.service.MaintenanceRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class MaintenanceRequestController {
    private final MaintenanceRequestService requestService;

    @Autowired
    public MaintenanceRequestController(MaintenanceRequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRequest>> getAllRequests() {
        return ResponseEntity.ok(requestService.getAllRequests());
    }

    @PostMapping
    public ResponseEntity<MaintenanceRequest> createRequest(@Valid @RequestBody MaintenanceRequest request) {
        return ResponseEntity.ok(requestService.createRequest(request));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<MaintenanceRequest> updateRequestStatus(@PathVariable Long id, @RequestParam MaintenanceRequest.RequestStatus status) {
        return ResponseEntity.ok(requestService.updateRequestStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return ResponseEntity.ok("Request deleted successfully");
    }
}