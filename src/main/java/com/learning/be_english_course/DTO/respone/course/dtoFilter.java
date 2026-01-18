package com.learning.be_english_course.DTO.respone.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dtoFilter {
    String imgUrl;
    String courseName;
    String level;
    BigDecimal price;
}
