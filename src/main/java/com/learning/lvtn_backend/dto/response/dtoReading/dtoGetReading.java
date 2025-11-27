package com.learning.lvtn_backend.dto.response.dtoReading;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetReading {
    int readingId;
    int lessonId;
    String passage;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctOption;
}
