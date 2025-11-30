package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Final_question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalQuestionRepository extends JpaRepository<Final_question, Long> {
}
