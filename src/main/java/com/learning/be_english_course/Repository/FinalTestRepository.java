package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Final_test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalTestRepository extends JpaRepository<Final_test, Long> {

//    @Query("""
//         SELECT new com.learning.be_english_course.DTO.respone.test.dtoTest (
//                          )
//         FROM PaymentCourse  pc
//         JOIN Course c ON pc.courseId = c.courseId
//         JOIN Payment p ON pc.paymentId = p.paymentId
//         WHERE pc.paymentId = :paymentId
//        """)
}
