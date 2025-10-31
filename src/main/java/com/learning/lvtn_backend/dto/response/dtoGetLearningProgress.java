package com.learning.lvtn_backend.dto.response;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;

import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetLearningProgress {
    int idUserCourse;
    int idLesson;
    BigDecimal progressPercent;
    LocalDateTime lastAccessed;
    String status;
}

