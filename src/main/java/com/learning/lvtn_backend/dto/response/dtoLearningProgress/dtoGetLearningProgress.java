package com.learning.lvtn_backend.dto.response.dtoLearningProgress;

import lombok.AccessLevel;
import lombok.Data;

import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetLearningProgress {
    int idProgress;
    int idUserCourse;
    int idLesson;
    BigDecimal progressPercent;
    LocalDateTime lastAccessed;
    String status;
}

