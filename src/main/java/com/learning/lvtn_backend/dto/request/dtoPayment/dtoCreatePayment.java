package com.learning.lvtn_backend.dto.request.dtoPayment;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoCreatePayment {
    int idUser;
    int idCourse;
    BigDecimal amount;
    String paymentMethod;
    String paymentStatus;
}

