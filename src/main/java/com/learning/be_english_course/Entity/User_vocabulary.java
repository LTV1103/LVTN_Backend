package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_vocabulary")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User_vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "save_Id")
    Long saveId;

    @Column(name = "user_Id")
    Long userId;

    @Column(name = "vocabulary_Id")
    Long vocabularyId;

    @Column(name = "saved_at")
    LocalDateTime savedAt;
}
