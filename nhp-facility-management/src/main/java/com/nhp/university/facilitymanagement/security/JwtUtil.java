package com.nhp.university.facilitymanagement.security;

import java.sql.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtil {

    @Value("${jwt.secret}") // Lấy khóa bí mật từ application.properties
    private String secret; // Khóa bí mật

    private long expiration = 3600000L; // Thời gian hết hạn của JWT (1 giờ)

    // Hàm tạo token
    public String generateToken(String email) {
        SecretKeySpec key = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS512.getJcaName());
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    // Hàm xác thực token (Nếu cần)
    public boolean validateToken(String token, String email) {
        String username = extractUsername(token);
        return (username.equals(email) && !isTokenExpired(token));
    }

    private String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
