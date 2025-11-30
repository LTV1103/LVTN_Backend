package com.learning.be_english_course.DTO.request.user_course;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateUserCourse {
     Long courseId;
     Long userId;
     LocalDateTime enrolledAt;
     String status;
}
