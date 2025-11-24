package com.learning.lvtn_backend.dto.response.dtoTestQuestion;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetTestQuestion {
    int idQuestion;
    int idTest;
    String questionText;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctOption;
    String explanation;
}
