package com.learning.be_english_course.DTO.request.user_vocabulary;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdateUserVocabulary {
    @Column(name = "user_Id")
    Long userId;

    @Column(name = "vocabulary_Id")
    Long vocabularyId;

}
