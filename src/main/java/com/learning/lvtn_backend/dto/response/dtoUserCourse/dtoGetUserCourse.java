package com.learning.lvtn_backend.dto.response.dtoUserCourse;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetUserCourse {
    int id_Course;
    int id_User;
    LocalDateTime enrolledAt;
    String status;
}
