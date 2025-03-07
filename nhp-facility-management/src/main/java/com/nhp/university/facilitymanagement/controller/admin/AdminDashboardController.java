package com.nhp.university.facilitymanagement.controller.admin;

import com.nhp.university.facilitymanagement.service.FacilityService;
import com.nhp.university.facilitymanagement.service.MaintenanceRequestService;
import com.nhp.university.facilitymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminDashboardController {
    private final UserService userService;
    private final FacilityService facilityService;
    private final MaintenanceRequestService requestService;

    @Autowired
    public AdminDashboardController(UserService userService, FacilityService facilityService, MaintenanceRequestService requestService) {
        this.userService = userService;
        this.facilityService = facilityService;
        this.requestService = requestService;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("totalUsers", userService.getAllUsers().size());
        model.addAttribute("totalFacilities", facilityService.getAllFacilities().size());
        model.addAttribute("newReports", requestService.getAllRequests().size());
        return "dashboard";
    }
}