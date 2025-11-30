package com.learning.be_english_course.DTO.request.final_question;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class dtoUpdateQuestion {
    Long finalQuestionId;
    String questionText;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctOption;
    String explanation;
}
