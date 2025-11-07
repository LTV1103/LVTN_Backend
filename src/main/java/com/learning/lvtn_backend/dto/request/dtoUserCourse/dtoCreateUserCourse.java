package com.learning.lvtn_backend.dto.request.dtoUserCourse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateUserCourse {
    int id_Course;
    int id_User;
    LocalDateTime enrolledAt;
    String status;
}

