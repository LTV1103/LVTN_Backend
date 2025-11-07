package com.learning.lvtn_backend.dto.response.dtoTestResult;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetTestResult {
    int idTest;
    int idUser;
    BigDecimal score;
    LocalDateTime completedAt;
}
