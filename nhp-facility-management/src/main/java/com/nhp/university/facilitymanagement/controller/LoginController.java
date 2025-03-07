package com.nhp.university.facilitymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller cho trang đăng nhập.
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String nhpLogin() {
        return "login"; // Trả về file login.html (nếu dùng Thymeleaf)
    }
}
