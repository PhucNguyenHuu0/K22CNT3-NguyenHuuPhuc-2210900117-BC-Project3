package com.nhp.university.facilitymanagement.service;

import com.nhp.university.facilitymanagement.model.MaintenanceRequest;
import com.nhp.university.facilitymanagement.repository.MaintenanceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestService {

    private final MaintenanceRequestRepository requestRepository;

    public MaintenanceRequestService(MaintenanceRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    // Phương thức GET - Lấy danh sách tất cả các Maintenance Requests
    public List<MaintenanceRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    // Phương thức POST - Tạo mới một Maintenance Request
    public MaintenanceRequest createRequest(MaintenanceRequest request) {
        return requestRepository.save(request);
    }

    // Phương thức DELETE - Xóa một Maintenance Request theo ID
    public void deleteRequest(Long id) {
        Optional<MaintenanceRequest> request = requestRepository.findById(id);
        if (request.isPresent()) {
            requestRepository.deleteById(id);
        } else {
            throw new RuntimeException("Request not found with id: " + id);
        }
    }
}
