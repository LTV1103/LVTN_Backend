package com.learning.lvtn_backend.dto.request.dtoUserCourse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateUserCourse {
     int courseId;
     int userId;
     LocalDateTime enrolledAt;
     String status;
}
