package com.learning.be_english_course.DTO.respone.user;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoOneUser {
    Long userId;
    String fullName;
    String email;
    String birthday;
    String phoneNumber;
    LocalDateTime createdAt;
}
