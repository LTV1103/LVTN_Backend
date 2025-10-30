package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Lesson")
    int idLesson;

    @Column(name = "id_Course")
    int idCourse;

    @Column(name = "lesson_title")
    String lessonTitle;

    @Column(name = "description")
    String description;

    @Column(name = "order_index")
    int orderIndex;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
