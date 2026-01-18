package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.payment.dtoDetailPayment;
import com.learning.be_english_course.DTO.respone.payment.dtoGetPayment;
import com.learning.be_english_course.DTO.respone.payment.dtoPaymentByUser;
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
       u.fullName , p.paymentId , p.amount , p.paymentMethod , p.paymentStatus , pc.createdAt
    )
    FROM Payment p
    JOIN User u ON p.userId = u.userId
    JOIN PaymentCourse pc ON p.paymentId = pc.paymentId
    
   
""")
    List<dtoGetPayment> getPayments();
//    @Query("SELECT p FROM Payment p WHERE p.paymentStatus IN ('success', 'failed')")
    @Query("""
    SELECT new com.learning.be_english_course.DTO.respone.payment.dtoPaymentByUser(
        p.paymentId , p.userId , p.amount , p.paymentMethod , p.paymentStatus , p.nameBank, pc.createdAt
    )
        FROM Payment p 
        JOIN PaymentCourse pc ON p.paymentId = pc.paymentId
        WHERE p.userId = :iduser
    """)
    List<dtoPaymentByUser> findPaymentByUserId(long iduser);
    @Query("SELECT SUM(p.amount) FROM Payment p")
    Long countAmount(BigDecimal amount);

}
