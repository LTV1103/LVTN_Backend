package com.learning.be_english_course.DTO.respone.user_vocabulary;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class dtoGetSaveVocabulary {
    Long saveId;
    String word;
    String meaning;
    String pronunciation;
    String audioUrl;
    LocalDateTime savedAt;

}
