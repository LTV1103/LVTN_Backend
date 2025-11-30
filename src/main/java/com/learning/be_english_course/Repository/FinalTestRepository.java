package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Final_test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalTestRepository extends JpaRepository<Final_test, Long> {
}
