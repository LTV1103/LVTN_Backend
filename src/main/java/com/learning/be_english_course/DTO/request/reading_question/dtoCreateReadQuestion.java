package com.learning.be_english_course.DTO.request.reading_question;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreateReadQuestion {
    @Column(name = "reading_Id")
    Long readingId;

    @Column(name = "question")
    String question;

    @Column(name = "option_a")
    String optionA;

    @Column(name = "option_b")
    String optionB;

    @Column(name = "option_c")
    String optionC;

    @Column(name = "option_d")
    String optionD;

    @Column(name = "correct_option")
    String correctOption;
}
