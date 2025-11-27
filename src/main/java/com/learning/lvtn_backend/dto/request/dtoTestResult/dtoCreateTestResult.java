package com.learning.lvtn_backend.dto.request.dtoTestResult;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateTestResult {
    int testId;
    int userId;
    BigDecimal score;
    LocalDateTime completedAt;
}

