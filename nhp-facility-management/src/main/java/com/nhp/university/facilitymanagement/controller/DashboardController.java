package com.nhp.university.facilitymanagement.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/dashboard")
public class DashboardController {

    @GetMapping
    public String getUserDashboard(Authentication authentication) {
        return "Xin chào USER: " + authentication.getName() + ". Đây là trang Dashboard của bạn.";
    }
}
