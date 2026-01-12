package com.learning.be_english_course.DTO.request.course;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateCourse {
    String courseName;
    String description;
//    String imgUrl;
    BigDecimal price;
    String level;
    String status;
}
