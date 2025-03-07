package com.nhp.university.facilitymanagement.controller.admin;

import com.nhp.university.facilitymanagement.service.FacilityService;
import com.nhp.university.facilitymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private final UserService userService;
    private final FacilityService facilityService;

    @Autowired
    public AdminController(UserService userService, FacilityService facilityService) {
        this.userService = userService;
        this.facilityService = facilityService;
    }

    @GetMapping("/admin")
    public String adminOverview(Model model) {
        try {
            model.addAttribute("totalUsers", userService.getAllUsers().size());
            model.addAttribute("totalFacilities", facilityService.getAllFacilities().size());
        } catch (Exception e) {
            model.addAttribute("totalUsers", 0);
            model.addAttribute("totalFacilities", 0);
            model.addAttribute("error", "Không thể tải dữ liệu: " + e.getMessage());
        }
        return "admin";
    }
}