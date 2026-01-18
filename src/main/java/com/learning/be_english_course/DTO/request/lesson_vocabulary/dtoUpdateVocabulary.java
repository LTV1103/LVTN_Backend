package com.learning.be_english_course.DTO.request.lesson_vocabulary;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateVocabulary {
    Long lessonId;
    String word;
    String meaning;
    String example;
    String pronunciation;
    private MultipartFile image;
    private MultipartFile audio;

}
