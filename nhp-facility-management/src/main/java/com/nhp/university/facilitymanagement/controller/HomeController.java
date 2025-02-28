package com.nhp.university.facilitymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";  // Trả về file templates/index.html
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/dashboard";  // Trả về file templates/admin/dashboard.html
    }
}
