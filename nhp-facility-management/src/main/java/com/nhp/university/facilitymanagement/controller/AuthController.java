package com.nhp.university.facilitymanagement.controller;

import com.nhp.university.facilitymanagement.security.JwtUtil;
import com.nhp.university.facilitymanagement.model.User;
import com.nhp.university.facilitymanagement.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest authRequest) {
        try {
            // Kiểm tra email và password
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
            
            // Tìm người dùng từ database
            User user = userService.findByEmail(authRequest.getEmail());
            
            // Nếu người dùng không tồn tại, trả về lỗi
            if (user == null) {
                return ResponseEntity.badRequest().body("User not found");
            }
            
            // Tạo JWT token
            final String jwt = jwtUtil.generateToken(user.getEmail());
            
            // Trả về AuthResponse chứa token
            return ResponseEntity.ok(new AuthResponse(jwt));
        } catch (AuthenticationException e) {
            // Xử lý lỗi khi authentication không thành công
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}

class AuthRequest {
    private String email;
    private String password;

    // Getter and Setter
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class AuthResponse {
    private String token;

    // Constructor, Getter, Setter
    public AuthResponse(String token) { this.token = token; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
