package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Listening_question;
import com.learning.be_english_course.Entity.Reading_question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListeningQuestionRepository extends JpaRepository<Listening_question, Long> {
    List<Listening_question> findByListeningId (Long readingId);

}
