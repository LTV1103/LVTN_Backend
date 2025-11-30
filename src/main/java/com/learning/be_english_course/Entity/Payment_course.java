package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Payment_course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment_course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_course_Id")
    Long paymentCourseId;

    @Column(name = "payment_Id")
    Long paymentId;

    @Column(name = "course_Id")
    Long courseId;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
