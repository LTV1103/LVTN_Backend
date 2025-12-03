package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "course")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_Id")
    Long courseId;

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
