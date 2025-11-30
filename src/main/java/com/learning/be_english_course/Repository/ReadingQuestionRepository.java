package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Reading_question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingQuestionRepository extends JpaRepository<Reading_question, Long> {
}
