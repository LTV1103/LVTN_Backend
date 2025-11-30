package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Final_result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalResultRepository extends JpaRepository<Final_result,Long> {
}
