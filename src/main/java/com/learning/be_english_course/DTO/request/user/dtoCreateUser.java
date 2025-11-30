package com.learning.be_english_course.DTO.request.user;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateUser {
    String fullName;
    String email;
    String password;
    String provider;
    String role;
    LocalDateTime createAt;
}
