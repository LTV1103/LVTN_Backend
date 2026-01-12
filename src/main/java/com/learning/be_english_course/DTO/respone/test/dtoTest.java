package com.learning.be_english_course.DTO.respone.test;

import com.learning.be_english_course.Entity.Final_question;
import com.learning.be_english_course.Entity.Final_test;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoTest {
    Long finalTestId;
    Long courseId;
    String testTitle;
    String description;
    Integer totalQuestions;
    Integer timeLimit;
    List<Final_question> finalQuestions;
}
