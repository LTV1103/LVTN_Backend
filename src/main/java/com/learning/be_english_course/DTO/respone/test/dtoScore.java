package com.learning.be_english_course.DTO.respone.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dtoScore {
    int correct;
    int wrong;
    double score;

}
