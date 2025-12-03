package com.learning.be_english_course.DTO.request.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateUser {
    String fullName;
    String phoneNumber;
    String birthday;
}
