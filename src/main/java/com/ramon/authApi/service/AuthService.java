package com.ramon.authApi.service;

import com.ramon.authApi.dto.LoginRequest;
import com.ramon.authApi.model.User;
import com.ramon.authApi.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    AuthRepository authRepository;

    public User findUserWithEmail(String email) {
        return authRepository.findByEmail(email);
    }

    public User registredUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return authRepository.save(user);
    }

    public User login(LoginRequest userData) {
        User user = authRepository.findByEmail(userData.getEmail());

        if (passwordEncoder.matches(userData.getPassword(), user.getPassword())) {
            return user;
        } else {
            return null;
        }

    }
}
