package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User_course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_course_Id")
    Long userCourseId;

    @Column(name = "course_Id")
    Long courseId;

    @Column(name = "user_Id")
    Long userId;

    @Column(name = "enrolled_at")
    LocalDateTime enrolledAt;

    @Column(name = "status")
    String status; // active / expired / cancelled
}
