package com.ramon.authApi.service;

import com.ramon.authApi.model.User;
import com.ramon.authApi.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {

    @Autowired
    AuthRepository authRepository;

    public User findUserWithEmail(String email) {
        return authRepository.findByEmail(email);
    }

}
