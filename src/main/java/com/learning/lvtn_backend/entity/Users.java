package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@Table(name = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User")
    int id;
    @Column(name = "full_name")
    String fullname;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "username")
    String username;
    @Column(name = "role")
    String role;
    @Column(name = "provider")
    String provider;
    @Column(name = "google_id")
    String googleId;
    @Column(name = "refresh_token")
    String refreshToken;
    @Column(name = "created_at")
    LocalDateTime createdAt;
}
