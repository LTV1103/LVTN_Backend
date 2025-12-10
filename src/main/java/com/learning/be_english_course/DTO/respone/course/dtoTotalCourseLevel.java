package com.learning.be_english_course.DTO.respone.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoTotalCourseLevel {
    private String level;
    private Long Total;
}
