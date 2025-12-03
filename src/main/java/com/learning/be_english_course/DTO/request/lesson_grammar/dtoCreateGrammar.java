package com.learning.be_english_course.DTO.request.lesson_grammar;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateGrammar {
    @Column(name = "lesson_Id")
    Long lessonId;

    @Column(name = "title")
    String title;

    @Column(name = "explanation")
    String explanation;

    @Column(name = "example")
    String example;
}
