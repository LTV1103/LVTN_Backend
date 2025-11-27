package com.learning.lvtn_backend.dto.request.dtoGrammar;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateGrammar {
     int lessonId;
     String title;
     String explanation;
     String example;
}
