package com.ramon.api_auth.service;

import org.springframework.http.ResponseEntity;
import com.ramon.api_auth.model.AuthRequest;
import com.ramon.api_auth.model.AuthResponse;

public class AuthServices {
    public static AuthResponse.Register Register(AuthRequest request) {
        AuthResponse.Register response = new AuthResponse.Register();
        response.setName(request.getName());
        response.setEmail(request.getEmail());
        response.setPassword(request.getPassword());

        return response;
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
