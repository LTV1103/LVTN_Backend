package com.learning.be_english_course.DTO.request.lesson_listening;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateListening {
    @Column(name = "lesson_Id")
    Long lessonId;

    @Column(name = "audio_url")
    String audioUrl;

    @Column(name = "transcript")
    String transcript;
}
