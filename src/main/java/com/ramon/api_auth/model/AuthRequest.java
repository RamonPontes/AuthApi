package com.ramon.api_auth.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthRequest {
    @Schema(description = "Name", example = "Ramon Pontes", required = true)
    private String name;

    @Schema(description = "Email", example = "ramon.pontes@example.com", required = true)
    private String email;

    @Schema(description = "Password", type = "string", format = "password", required = true)
    private String password;

    @Schema(description = "Phone", example = "+123456", required = false)
    private String phone;

    @Schema(description = "Age", example = "15", required = false)
    private Integer age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}
