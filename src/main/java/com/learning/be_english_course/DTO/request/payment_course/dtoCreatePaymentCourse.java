package com.learning.be_english_course.DTO.request.payment_course;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreatePaymentCourse {
    @Column(name = "payment_Id")
    Long paymentId;

    @Column(name = "course_Id")
    Long courseId;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
