package com.learning.be_english_course.DTO.request.lesson_grammar;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateGrammar {
    Long lessonId;
    String title;
    String explanation;
    String example;
    private MultipartFile video;



}
