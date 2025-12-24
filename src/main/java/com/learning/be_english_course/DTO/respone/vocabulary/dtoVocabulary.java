package com.learning.be_english_course.DTO.respone.vocabulary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dtoVocabulary {
    private String word;
    private String meaning;
    private String example;
    private String pronunciation;
    private String audioUrl;
}
