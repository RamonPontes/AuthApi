package com.ramon.api_auth.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.api_auth.model.AuthRequest;
import com.ramon.api_auth.service.AuthServices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(value = "/api/auth", produces = { "application/json" })
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
            @Parameter(description = "Email", required = true) @RequestParam String email,

            @Parameter(description = "Password", required = true) @RequestParam String password) {
        return ResponseEntity.ok("OK " + email + " " + password);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody AuthRequest request) {
        System.out.print(request.getName());

        return ResponseEntity.status(200).body(AuthServices.Register(request));
    }
    
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword() {
        return ResponseEntity.ok("Password Changed");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser() {
        return ResponseEntity.noContent().build();
    }
}