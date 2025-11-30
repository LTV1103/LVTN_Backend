package com.learning.be_english_course.DTO.request.final_result;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateResult {

    @Column(name = "final_test_Id")
    Long finalTestId;

    @Column(name = "user_Id")
    Long userId;

    @Column(name = "score")
    BigDecimal score;

    @Column(name = "completed_at")
    LocalDateTime completedAt;
}
