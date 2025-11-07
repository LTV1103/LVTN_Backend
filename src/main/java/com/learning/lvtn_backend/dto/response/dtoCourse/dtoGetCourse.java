package com.learning.lvtn_backend.dto.response.dtoCourse;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetCourse {
    String courseName;
    String description;
    String imgUrl;
    BigDecimal price;
    String level;
    String status;
    LocalDateTime createdAt;
}

