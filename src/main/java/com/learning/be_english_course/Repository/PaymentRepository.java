package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.payment.dtoDetailPayment;
import com.learning.be_english_course.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(long iduser);
}
