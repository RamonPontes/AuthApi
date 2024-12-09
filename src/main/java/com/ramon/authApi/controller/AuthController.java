package com.ramon.authApi.controller;

import com.ramon.authApi.model.User;
import com.ramon.authApi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userData) {
        if (userData.isAnyFieldNull()) { ResponseEntity.status(400).body("All fields are required"); }

        if (authService.findUserWithEmail(userData.getEmail()) != null) { return ResponseEntity.status(409).body("Email already registered"); }

        return ResponseEntity.status(200).body(authService.registredUser(userData));
    }
}
