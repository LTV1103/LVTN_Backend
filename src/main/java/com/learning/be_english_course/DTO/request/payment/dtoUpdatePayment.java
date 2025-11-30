package com.learning.be_english_course.DTO.request.payment;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdatePayment {
     Long userId;
     BigDecimal amount;
     String paymentMethod;
     String paymentStatus;
}
