package com.learning.lvtn_backend.dto.request.dtoLesson;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateLesson {
    int courseId;
    String lessonTitle;
    String description;
    int orderIndex;
    LocalDateTime createdAt;
}

