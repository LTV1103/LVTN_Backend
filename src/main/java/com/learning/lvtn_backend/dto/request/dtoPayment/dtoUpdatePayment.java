package com.learning.lvtn_backend.dto.request.dtoPayment;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoUpdatePayment {
     int idUser;
     int idCourse;
     BigDecimal amount;
     String paymentMethod;
     String paymentStatus;
}
