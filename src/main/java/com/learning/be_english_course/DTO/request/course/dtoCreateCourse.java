package com.learning.be_english_course.DTO.request.course;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateCourse {
    String courseName;
    String description;
//    String imgUrl;
    BigDecimal price;
    String level;
    String status;
    LocalDateTime createdAt;
}
