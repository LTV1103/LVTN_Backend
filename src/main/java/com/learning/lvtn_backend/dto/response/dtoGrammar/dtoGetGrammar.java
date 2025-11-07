package com.learning.lvtn_backend.dto.response.dtoGrammar;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetGrammar {
    int idLesson;
    String title;
    String explanation;
    String example;

}
