package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Payment_course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentCourseRepository extends JpaRepository<Payment_course, Long> {
    List<Payment_course> findByPaymentId(long paymentId);
}
