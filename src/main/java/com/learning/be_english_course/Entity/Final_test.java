package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "final_test")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Final_test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "final_test_Id")
    Long finalTestId;

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
