package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.payment.dtoDetailPayment;
import com.learning.be_english_course.DTO.respone.payment_course.dtoChartMonth;
import com.learning.be_english_course.Entity.Payment_course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentCourseRepository extends JpaRepository<Payment_course, Long> {
        @Query("""
        SELECT new com.learning.be_english_course.DTO.respone.payment.dtoDetailPayment (
           c.courseName, c.price , c.level , pc.createdAt , c.imgUrl
        )
        FROM PaymentCourse  pc
        JOIN Course c ON pc.courseId = c.courseId
     
        WHERE pc.paymentId = :paymentId
        """)
    List <dtoDetailPayment> findPaymentById(long paymentId);
    List<Payment_course> findByPaymentId(long paymentId);

    @Query(value = """
        SELECT MONTH(created_at) AS month,
               COUNT(*) AS total
        FROM payment_course
        GROUP BY MONTH(created_at)
        ORDER BY MONTH(created_at)
        """, nativeQuery = true)
    List<dtoChartMonth> countPaymentCourseByMonth();




}
