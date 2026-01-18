package com.learning.be_english_course.DTO.request.lesson_listening;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateListening {
    Long lessonId;
    private MultipartFile audio;
    String transcript;
}
