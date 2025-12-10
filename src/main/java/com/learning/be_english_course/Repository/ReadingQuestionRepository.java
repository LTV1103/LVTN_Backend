package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Reading_question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingQuestionRepository extends JpaRepository<Reading_question, Long> {
    List<Reading_question> findByReadingId (Long readingId);
}

