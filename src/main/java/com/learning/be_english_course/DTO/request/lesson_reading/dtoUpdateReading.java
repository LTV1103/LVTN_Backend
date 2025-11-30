package com.learning.be_english_course.DTO.request.lesson_reading;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateReading {
    @Column(name = "lesson_Id")
    Long lessonId;

    @Column(name = "passage")
    String passage;
}
