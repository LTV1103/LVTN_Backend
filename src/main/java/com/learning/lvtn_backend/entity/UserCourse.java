package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User_Course")
    int userCourseId;

    @Column(name = "id_Course")
    int courseId;

    @Column(name = "id_User")
    int userId;

    @Column(name = "enrolled_at")
    LocalDateTime enrolledAt;

    @Column(name = "status")
    String status;
}
