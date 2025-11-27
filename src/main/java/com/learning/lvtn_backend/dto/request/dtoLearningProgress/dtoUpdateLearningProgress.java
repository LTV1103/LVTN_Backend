package com.learning.lvtn_backend.dto.request.dtoLearningProgress;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateLearningProgress {
     int userCourseId;
     int lessonId;
     BigDecimal progressPercent;
     LocalDateTime lastAccessed;
     String status;
}
