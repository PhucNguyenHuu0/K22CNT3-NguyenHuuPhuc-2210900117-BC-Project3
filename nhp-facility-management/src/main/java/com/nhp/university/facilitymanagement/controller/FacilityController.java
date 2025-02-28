package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.model.Facility;
import com.nhp.university.facilitymanagement.service.FacilityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @PostMapping
    public Facility createFacility(@RequestBody Facility facility, @RequestParam Long userId) {
        return facilityService.createFacility(facility, userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
        return ResponseEntity.ok("Facility deleted successfully");
    }
}
