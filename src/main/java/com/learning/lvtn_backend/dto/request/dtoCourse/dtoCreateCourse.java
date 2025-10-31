package com.learning.lvtn_backend.dto.request.dtoCourse;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateCourse {
    String courseName;
    String description;
    String imgUrl;
    BigDecimal price;
    String level;
    String status;
    LocalDateTime createdAt;
}

