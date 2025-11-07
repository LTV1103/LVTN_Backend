package com.learning.lvtn_backend.dto.request.dtoVocabulary;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateVocabulary {
    int idLesson;
    String word;
    String meaning;
    String example;
    String pronunciation;
    String audioUrl;
}

