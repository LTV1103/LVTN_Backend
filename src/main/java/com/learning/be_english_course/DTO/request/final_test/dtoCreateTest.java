package com.learning.be_english_course.DTO.request.final_test;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateTest {
    @Column(name = "course_Id")
    Long courseId;

    @Column(name = "test_title")
    String testTitle;

    @Column(name = "description")
    String description;

    @Column(name = "total_questions")
    Integer totalQuestions;

    @Column(name = "time_limit")
    Integer timeLimit;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
