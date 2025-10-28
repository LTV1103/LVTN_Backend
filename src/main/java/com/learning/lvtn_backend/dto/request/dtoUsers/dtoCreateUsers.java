package com.learning.lvtn_backend.dto.request.dtoUsers;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class dtoCreateUsers {
    private String name;
    private String email;
    private String password;
    private String username;
    private String role;
    private String provider;
    private String googleId;
    private String refreshToken;
    private String createdAt;
}

