package com.learning.be_english_course.DTO.respone.progress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoProgress {
    private String LessonName;
    private String courseName;
    private Long ProgressId;
    private Long UserId;
    private BigDecimal ProgressPercent;
    private LocalDateTime lastAccessed;
    private String status;


}
