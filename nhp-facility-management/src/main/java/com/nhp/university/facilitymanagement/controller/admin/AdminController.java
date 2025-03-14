package com.nhp.university.facilitymanagement.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/admin/dashboard")
public class AdminController {

    @GetMapping
    public String showAdminDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "admin/dashboard"; // Chỉ Admin mới vào được
        }
        return "redirect:/access-denied"; // Nếu không phải Admin thì từ chối truy cập
    }

    @GetMapping("/api")
    public String getAdminDashboard(Authentication authentication) {
        return "Xin chào ADMIN: " + authentication.getName() + ". Đây là trang Dashboard của Admin.";
    }
}
