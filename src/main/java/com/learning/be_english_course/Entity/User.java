package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Entity

@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    Long userId;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "birthday")
    String birthday;

    @Column(name = "phone_number")
    String phoneNumber;


    @Column(name = "refresh_token")
    String refreshToken;

    @Column(name = "provider")
    String provider; // local / google

    @Column(name = "role")
    String role; // admin / user

    @Column(name = "created_at")
    LocalDateTime createdAt;

}
