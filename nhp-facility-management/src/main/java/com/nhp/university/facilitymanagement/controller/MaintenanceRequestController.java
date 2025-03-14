package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.MaintenanceRequest;
import com.nhp.university.facilitymanagement.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-requests")
public class MaintenanceRequestController {

    private final MaintenanceRequestService maintenanceRequestService;

    @Autowired
    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRequest>> getAllRequests() {
        return ResponseEntity.ok(maintenanceRequestService.getAllRequests());
    }

    @PostMapping
    public ResponseEntity<MaintenanceRequest> createRequest(@RequestBody MaintenanceRequest request) {
        return ResponseEntity.ok(maintenanceRequestService.createRequest(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceRequest> getRequestById(@PathVariable Long id) {
        return ResponseEntity.ok(maintenanceRequestService.getRequestById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceRequest> updateRequest(@PathVariable Long id, @RequestBody MaintenanceRequest request) {
        request.setId(id);
        return ResponseEntity.ok(maintenanceRequestService.updateRequest(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        maintenanceRequestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}