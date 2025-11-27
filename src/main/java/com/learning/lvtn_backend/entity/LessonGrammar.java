package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson_grammar")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonGrammar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Grammar")
    int grammarId;

    @Column(name = "id_Lesson")
    int lessonId;

    @Column(name = "title")
    String title;

    @Column(name = "explanation")
    String explanation;

    @Column(name = "example")
    String example;
}
