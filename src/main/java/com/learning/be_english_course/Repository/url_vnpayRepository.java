package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.URL_VNPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface url_vnpayRepository extends JpaRepository<URL_VNPay, Long> {
}
