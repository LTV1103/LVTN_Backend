package com.learning.lvtn_backend.dto.request.dtoListening;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateListening {
     int lessonId;
     String audioUrl;
     String transcript;
     String question;
     String optionA;
     String optionB;
     String optionC;
     String optionD;
     String correctOption;
}
