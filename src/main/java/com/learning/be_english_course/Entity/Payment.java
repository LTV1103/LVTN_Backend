package com.learning.be_english_course.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "payment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_Id")
    Long paymentId;

    @Column(name = "user_Id")
    Long userId;

    @Column(name = "amount")
    BigDecimal amount;

    @Column(name = "payment_method")
    String paymentMethod; // vn_pay

    @Column(name = "payment_status")
    String paymentStatus; // pending / success / failed

    @Column(name = "nameBank")
    String nameBank;
}
