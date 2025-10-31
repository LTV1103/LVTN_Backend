package com.learning.lvtn_backend.dto.request.dtoCourse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateCourse {
     String courseName;
     String description;
     String imgUrl;
     BigDecimal price;
     String level;
     String status;
}
