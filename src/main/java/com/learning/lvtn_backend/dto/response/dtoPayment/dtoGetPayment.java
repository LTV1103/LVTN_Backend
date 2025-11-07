package com.learning.lvtn_backend.dto.response.dtoPayment;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class dtoGetPayment {
    int idUser;
    int idCourse;
    BigDecimal amount;
    String paymentMethod;
    String paymentStatus;
}

