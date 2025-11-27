package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lesson_vocabulary")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonVocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vocabulary")
    int vocabularyId;

    @Column(name = "id_Lesson")
    int lessonId;

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
