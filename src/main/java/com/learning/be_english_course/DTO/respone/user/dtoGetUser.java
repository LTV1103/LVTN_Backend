package com.learning.be_english_course.DTO.respone.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetUser {
    Long userId;
    String fullName;
    String email;
    String birthday;
    String phoneNumber;
    String role;
    LocalDateTime createdAt;
}
