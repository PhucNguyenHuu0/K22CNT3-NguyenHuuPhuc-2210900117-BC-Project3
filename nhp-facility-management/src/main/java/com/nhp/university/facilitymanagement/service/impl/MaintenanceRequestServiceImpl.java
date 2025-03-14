package com.nhp.university.facilitymanagement.service.impl;

import com.nhp.university.facilitymanagement.model.MaintenanceRequest;
import com.nhp.university.facilitymanagement.repository.MaintenanceRequestRepository;
import com.nhp.university.facilitymanagement.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {

    private final MaintenanceRequestRepository maintenanceRequestRepository;

    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepository maintenanceRequestRepository) {
        this.maintenanceRequestRepository = maintenanceRequestRepository;
    }

    @Override
    public MaintenanceRequest createRequest(MaintenanceRequest maintenanceRequest) {
        maintenanceRequest.setCreatedAt(LocalDateTime.now());
        return maintenanceRequestRepository.save(maintenanceRequest);
    }

    @Override
    public List<MaintenanceRequest> getAllRequests() {
        return maintenanceRequestRepository.findAll();
    }

    @Override
    public MaintenanceRequest getRequestById(Long id) {
        return maintenanceRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
    }

    @Override
    public MaintenanceRequest updateRequest(MaintenanceRequest request) {
        return maintenanceRequestRepository.save(request);
    }

    @Override
    public void deleteRequest(Long id) {
        maintenanceRequestRepository.deleteById(id);
    }
}