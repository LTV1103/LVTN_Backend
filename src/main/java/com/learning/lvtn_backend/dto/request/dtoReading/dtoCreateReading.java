package com.learning.lvtn_backend.dto.request.dtoReading;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateReading {
    int lessonId;
    String passage;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctOption;
}

