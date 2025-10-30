package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "learning_progress")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LearningProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progress")
    int idProgress;

    @Column(name = "id_user_course")
    int idUserCourse;

    @Column(name = "id_lesson")
    int idLesson;

    @Column(name = "progress_percent")
    BigDecimal progressPercent;

    @Column(name = "last_accessed")
    LocalDateTime lastAccessed;

    @Column(name = "status")
    String status;
}
