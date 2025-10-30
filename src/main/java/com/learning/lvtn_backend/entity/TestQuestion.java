package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_question")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Question")
    int idQuestion;

    @Column(name = "id_Test")
    int idTest;

    @Column(name = "question_text")
    String questionText;

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

    @Column(name = "explanation")
    String explanation;
}
