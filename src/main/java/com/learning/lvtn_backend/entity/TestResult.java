package com.learning.lvtn_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_result")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Result")
    int resultId;

    @Column(name = "id_Test")
    int testId;

    @Column(name = "id_User")
    int userId;

    @Column(name = "score")
    BigDecimal score;

    @Column(name = "completed_at")
    LocalDateTime completedAt;
}
