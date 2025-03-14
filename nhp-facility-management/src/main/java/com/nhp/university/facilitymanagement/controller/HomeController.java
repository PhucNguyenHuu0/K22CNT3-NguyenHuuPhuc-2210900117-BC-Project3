package com.nhp.university.facilitymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homePage() {
        return "Chào mừng bạn đến với Hệ thống Quản lý Cơ sở vật chất!";
    }
}
