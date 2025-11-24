package com.learning.lvtn_backend.dto.request.dtoPayment;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VNPayRequest {
    long idPayment;
    long idUser;
    String idCourse;
    long amount;
    String paymentMethod;
    String paymentStatus;
}
