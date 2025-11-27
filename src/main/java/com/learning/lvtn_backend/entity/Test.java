package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Test")
    int testId;

    @Column(name = "id_Course")
    int courseId;

    @Column(name = "test_title")
    String testTitle;

    @Column(name = "description")
    String description;

    @Column(name = "test_type")
    String testType;

    @Column(name = "total_questions")
    int totalQuestions;

    @Column(name = "time_limit")
    int timeLimit;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
