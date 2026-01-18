package com.learning.be_english_course.DTO.request.progress;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateProgress {
    @Column(name = "progress_percent")
    BigDecimal progressPercent;

    @Column(name = "last_accessed")
    LocalDateTime lastAccessed;

    @Column(name = "status")
    String status; // not_started / learning / completed
}
