package com.learning.be_english_course.DTO.respone.lesson;

import com.learning.be_english_course.DTO.respone.grammar.dtoGrammar;
import com.learning.be_english_course.DTO.respone.listening.dtoListening;
import com.learning.be_english_course.DTO.respone.reading.dtoReading;
import com.learning.be_english_course.DTO.respone.vocabulary.dtoVocabulary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class dtoDetailLesson {
    private Long lessonId;
    private String lessonTitle;
    private String description;

    private List<dtoVocabulary> vocabulary;
    private List<dtoGrammar> grammar;

    private List<dtoReading> reading;
    private List<dtoListening> listening;
}
