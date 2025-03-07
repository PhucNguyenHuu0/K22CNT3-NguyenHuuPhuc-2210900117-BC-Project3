package com.nhp.university.facilitymanagement.controller.admin;

import com.nhp.university.facilitymanagement.model.User;
import com.nhp.university.facilitymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminUserController {
    private final UserService NHPUserService;

    @Autowired
    public AdminUserController(UserService NHPUserService) {
        this.NHPUserService = NHPUserService;
    }

    @GetMapping
    public String getAllUsers(Model NHPModel) {
        try {
            NHPModel.addAttribute("NHPUsers", NHPUserService.getAllUsers());
        } catch (Exception NHPException) {
            NHPModel.addAttribute("NHPUsers", null);
            NHPModel.addAttribute("NHPError", "Không thể tải danh sách người dùng: " + NHPException.getMessage());
        }
        return "users";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model NHPModel) {
        NHPModel.addAttribute("NHPUser", new User());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("NHPUser") User NHPUser, Model NHPModel) {
        try {
            NHPUserService.createUser(NHPUser);
            return "redirect:/admin/users";
        } catch (IllegalArgumentException NHPException) {
            NHPModel.addAttribute("NHPError", NHPException.getMessage());
            NHPModel.addAttribute("NHPUser", NHPUser);
            return "add-user";
        }
    }
}