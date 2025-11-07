package com.learning.lvtn_backend.dto.response.dtoVocabulary;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetVocabulary {
    int idLesson;
    String word;
    String meaning;
    String example;
    String pronunciation;
    String audioUrl;
}
