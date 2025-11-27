package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.Payment_Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentCourseRepository extends JpaRepository<Payment_Course,Integer> {
    List<Payment_Course> findByIdPayment(int paymentId);
}
