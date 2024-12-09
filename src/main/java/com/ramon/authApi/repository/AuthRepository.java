package com.ramon.authApi.repository;

import com.ramon.authApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
