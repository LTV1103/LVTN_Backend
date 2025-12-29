package com.learning.be_english_course.DTO.request.lesson;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateLesson {


    @Column(name = "course_Id")
    Long courseId;

    @Column(name = "lesson_title")
    String lessonTitle;

    @Column(name = "description")
    String description;



    @Column(name = "created_at")
    LocalDateTime createdAt;
}
