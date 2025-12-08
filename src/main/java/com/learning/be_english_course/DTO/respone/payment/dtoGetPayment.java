package com.learning.be_english_course.DTO.respone.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetPayment {
    String fullName;
    long paymentId;
    BigDecimal amount;
    String paymentMethod;
    String paymentStatus;


}
