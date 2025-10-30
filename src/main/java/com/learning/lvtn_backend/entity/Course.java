package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Course")
    int id_Course;

    @Column(name = "course_name")
    String courseName;

    @Column(name = "description")
    String description;

    @Column(name = "img_url")
    String imgUrl;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "level")
    String level;

    @Column(name = "status")
    String status;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
