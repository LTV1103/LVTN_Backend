package com.learning.lvtn_backend.dto.request.dtoTest;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateTest {
     int idCourse;
     String testTitle;
     String description;
     String testType;
     int totalQuestions;
     int timeLimit;
     LocalDateTime createdAt;
}
