package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User")
    private int id;
    @Column(name = "full_name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;
    @Column(name = "role")
    private String role;
    @Column(name = "provider")
    private String provider;
    @Column(name = "google_id")
    private String googleId;
    @Column(name = "refresh_token")
    private String refreshToken;
    @Column(name = "created_at")
    private String createdAt;
}
