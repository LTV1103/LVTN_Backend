package com.learning.be_english_course.DTO.respone.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoResult {
    String TestName;
    BigDecimal score;
    LocalDateTime completedAt;
}
