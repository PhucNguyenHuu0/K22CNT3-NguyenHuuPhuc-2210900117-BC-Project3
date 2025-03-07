package com.nhp.university.facilitymanagement.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String userPage() {
        return "Welcome to the User page!";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String adminPage() {
        return "Welcome to the Admin page!";
    }
}
