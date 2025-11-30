package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "Lesson_grammar")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lesson_grammar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grammar_Id")
    Long grammarId;

    @Column(name = "lesson_Id")
    Long lessonId;

    @Column(name = "title")
    String title;

    @Column(name = "explanation")
    String explanation;

    @Column(name = "example")
    String example;
}
