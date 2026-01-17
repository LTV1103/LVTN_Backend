package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.payment.dtoDetailPayment;
import com.learning.be_english_course.DTO.respone.payment.dtoGetPayment;
import com.learning.be_english_course.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("""
    SELECT new com.learning.be_english_course.DTO.respone.payment.dtoGetPayment (
       u.fullName , p.paymentId , p.amount , p.paymentMethod , p.paymentStatus
    )
    FROM Payment p
    JOIN User u ON p.userId = u.userId
   
""")
    List<dtoGetPayment> getPayments();
//    @Query("SELECT p FROM Payment p WHERE p.paymentStatus IN ('success', 'failed')")
    List<Payment> findByUserId(long iduser);
    @Query("SELECT SUM(p.amount) FROM Payment p")
    Long countAmount(BigDecimal amount);

}
