package com.ramon.authApi.controller;

import com.ramon.authApi.dto.LoginRequest;
import com.ramon.authApi.model.User;
import com.ramon.authApi.service.AuthService;
import com.ramon.authApi.service.JwtService;
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

    @Autowired
    JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userData) {
        if (userData.isAnyFieldNull()) { return ResponseEntity.status(400).body("All fields are required"); }

        if (authService.findUserWithEmail(userData.getEmail()) != null) { return ResponseEntity.status(409).body("Email already registered"); }

        return ResponseEntity.status(200).body(authService.registredUser(userData));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest userData) {
        if (userData.isAnyFieldNull()) { return ResponseEntity.status(400).body("All fields are required"); }

        if (authService.findUserWithEmail(userData.getEmail()) == null) { return ResponseEntity.status(404).body("User not found"); }

        User login = authService.login(userData);

        if (login == null) {
            return ResponseEntity.status(401).body("Invalid password");
        } else {
            System.out.println(jwtService.validateToken(jwtService.generateToken(login)));

            return ResponseEntity.status(200).body(jwtService.generateToken(login));
        }
    }
}
