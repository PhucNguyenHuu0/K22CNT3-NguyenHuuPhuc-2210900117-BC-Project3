package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.Facility;
import com.nhp.university.facilitymanagement.service.FacilityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {
    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        return ResponseEntity.ok(facilityService.getAllFacilities());
    }

    @PostMapping
    public ResponseEntity<Facility> createFacility(@Valid @RequestBody Facility facility, @RequestParam Long userId) {
        return ResponseEntity.ok(facilityService.addFacility(facility, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
        return ResponseEntity.ok("Facility deleted successfully");
    }
}