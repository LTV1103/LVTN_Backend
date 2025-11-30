package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Test_result")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Final_result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_test_Id")
    Long resultTestId;

    @Column(name = "final_test_Id")
    Long finalTestId;

    @Column(name = "user_Id")
    Long userId;

    @Column(name = "score")
    BigDecimal score;

    @Column(name = "completed_at")
    LocalDateTime completedAt;

}
