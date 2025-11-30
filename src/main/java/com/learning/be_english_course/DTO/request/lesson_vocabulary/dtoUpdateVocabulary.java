package com.learning.be_english_course.DTO.request.lesson_vocabulary;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateVocabulary {
    @Column(name = "lesson_Id")
    Long lessonId;

    @Column(name = "word")
    String word;

    @Column(name = "meaning")
    String meaning;

    @Column(name = "example")
    String example;

    @Column(name = "pronunciation")
    String pronunciation;

    @Column(name = "audio_url")
    String audioUrl;
}
