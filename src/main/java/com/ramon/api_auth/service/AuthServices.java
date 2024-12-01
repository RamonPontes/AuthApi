package com.ramon.api_auth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ramon.api_auth.model.AuthRequest;

@Service
public class AuthServices {
    public static ResponseEntity<Object> Register(AuthRequest.Register request) {
        if (request.getName() == null || request.getName().isEmpty() || request.getEmail() == null || request.getEmail().isEmpty() || request.getPassword() == null || request.getPassword().isEmpty()) {
            return ResponseEntity.status(400).body("All fields are required");
        }


        return ResponseEntity.status(200).body("OK");
    }

    public ResponseEntity<Object> Login() {
        return ResponseEntity.ok("OK");
    }

    public ResponseEntity<Object> ChangePassword() {
        return ResponseEntity.ok("OK");
    }

    public ResponseEntity<Object> Delete() {
        return ResponseEntity.ok("OK");
    }
}
