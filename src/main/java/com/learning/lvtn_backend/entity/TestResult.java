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
    int idResult;

    @Column(name = "id_Test")
    int idTest;

    @Column(name = "id_User")
    int idUser;

    @Column(name = "score")
    BigDecimal score;

    @Column(name = "completed_at")
    LocalDateTime completedAt;
}
