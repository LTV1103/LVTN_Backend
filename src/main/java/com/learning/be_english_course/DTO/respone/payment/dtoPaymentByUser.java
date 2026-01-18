package com.learning.be_english_course.DTO.respone.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoPaymentByUser {
    long paymentId;
    long userId;
    BigDecimal amount;
    String paymentMethod;
    String paymentStatus;
    String nameBank;
    LocalDateTime createdAt;
}
