package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "lesson_listening")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lesson_listening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listening_Id")
    Long listeningId;

    @Column(name = "lesson_Id")
    Long lessonId;

    @Column(name = "audio_url")
    String audioUrl;

    @Column(name = "transcript")
    String transcript;
}

