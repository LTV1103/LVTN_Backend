package com.learning.lvtn_backend.dto.response.dtoTest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetTest {
    int testId;
    int courseId;
    String testTitle;
    String description;
    String testType;
    int totalQuestions;
    int timeLimit;
    LocalDateTime createdAt;
}
