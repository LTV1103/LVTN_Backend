package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "progress")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_Id")
    Long progressId;

    @Column(name = "user_course_Id")
    Long userCourseId;

    @Column(name = "lesson_Id")
    Long lessonId;

    @Column(name = "progress_percent")
    BigDecimal progressPercent;

    @Column(name = "last_accessed")
    LocalDateTime lastAccessed;

    @Column(name = "status")
    String status; // not_started / learning / completed
}
