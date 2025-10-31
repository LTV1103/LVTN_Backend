package com.learning.lvtn_backend.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetLesson {
    int idCourse;
    String lessonTitle;
    String description;
    int orderIndex;
    LocalDateTime createdAt;
}

