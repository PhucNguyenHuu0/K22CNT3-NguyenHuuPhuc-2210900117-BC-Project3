package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.MaintenanceRequest;
import java.util.List;

public interface MaintenanceRequestService {
    MaintenanceRequest createRequest(MaintenanceRequest maintenanceRequest);
    List<MaintenanceRequest> getAllRequests();
    MaintenanceRequest getRequestById(Long id);
    MaintenanceRequest updateRequest(MaintenanceRequest request);
    void deleteRequest(Long id);
}