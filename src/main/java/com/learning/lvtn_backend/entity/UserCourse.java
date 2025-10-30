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
    int id_User_Course;

    @Column(name = "id_Course")
    int id_Course;

    @Column(name = "id_User")
    int id_User;

    @Column(name = "enrolled_at")
    LocalDateTime enrolledAt;

    @Column(name = "status")
    String status;
}
