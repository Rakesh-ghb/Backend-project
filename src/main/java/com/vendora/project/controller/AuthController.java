package com.vendora.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vendora.project.dto.LoginRequest;
import com.vendora.project.dto.RegisterRequest;
import com.vendora.project.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // ✅ REGISTER API (DTO based)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        authService.register(request);

        return ResponseEntity.ok(
                Map.of("message", "User registered successfully")
        );
    }

    // ✅ LOGIN API (JWT)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        String token = authService.login(loginRequest);

        return ResponseEntity.ok(
                Map.of("token", token)
        );
    }
}
