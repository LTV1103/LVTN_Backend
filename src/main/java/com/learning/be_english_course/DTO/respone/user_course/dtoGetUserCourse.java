package com.learning.be_english_course.DTO.respone.user_course;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetUserCourse {
    Long courseId;
    Long userId;
    LocalDateTime enrolledAt;
    String status;
}
