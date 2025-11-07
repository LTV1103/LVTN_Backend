package com.learning.lvtn_backend.dto.response.dtoListening;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetListening {
    int idLesson;
    String audioUrl;
    String transcript;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctOption;
}
