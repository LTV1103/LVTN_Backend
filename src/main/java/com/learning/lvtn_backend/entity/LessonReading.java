package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson_reading")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Reading")
    int idReading;

    @Column(name = "id_Lesson")
    int idLesson;

    @Column(name = "passage")
    String passage;

    @Column(name = "question")
    String question;

    @Column(name = "option_a")
    String optionA;

    @Column(name = "option_b")
    String optionB;

    @Column(name = "option_c")
    String optionC;

    @Column(name = "option_d")
    String optionD;

    @Column(name = "correct_option")
    String correctOption;
}
