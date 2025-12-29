package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "lesson")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_Id")
    Long lessonId;

    @Column(name = "course_Id")
    Long courseId;

    @Column(name = "lesson_title")
    String lessonTitle;

    @Column(name = "description")
    String description;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
