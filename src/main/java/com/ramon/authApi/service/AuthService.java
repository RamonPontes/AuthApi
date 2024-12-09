package com.ramon.authApi.service;

import com.ramon.authApi.model.User;
import com.ramon.authApi.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthRepository authRepository;

    public User findUserWithEmail(String email) {
        return authRepository.findByEmail(email);
    }

}
