package com.learning.be_english_course.DTO.request.final_question;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateQuestion {
    Long finalTestId;
    String questionText;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctOption;
    String explanation;
}
