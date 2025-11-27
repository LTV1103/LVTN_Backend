package com.learning.lvtn_backend.dto.request.dtoTestQuestion;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateTestQuestion {
     int testId;
     String questionText;
     String optionA;
     String optionB;
     String optionC;
     String optionD;
     String correctOption;
     String explanation;
}
