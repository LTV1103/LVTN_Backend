package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_course")
    int paymentCourseId;
    @Column(name = "id_payment")
    int idPayment;
    @Column(name = "id_Course")
    int courseId;
    @Column(name = "created_at")
    LocalDateTime createdAt;

}
