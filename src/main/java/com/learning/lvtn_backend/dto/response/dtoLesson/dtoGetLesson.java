package com.learning.lvtn_backend.dto.response.dtoLesson;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetLesson {
    int idLesson;
    String lessonTitle;
    String description;
    LocalDateTime createdAt;
}

