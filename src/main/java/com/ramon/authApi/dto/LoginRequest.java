package com.ramon.authApi.dto;

public class LoginRequest {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isAnyFieldNull() {
        return getEmail() == null || getPassword() == null;
    }
}
