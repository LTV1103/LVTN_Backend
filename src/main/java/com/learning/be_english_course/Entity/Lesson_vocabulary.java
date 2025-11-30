package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "Lesson_vocabulary")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lesson_vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vocabulary_Id")
    Long vocabularyId;

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
