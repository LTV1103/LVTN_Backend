package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Lesson_grammar;
import com.learning.be_english_course.Entity.Lesson_vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonGrammarRepository extends JpaRepository<Lesson_grammar, Long> {
    List<Lesson_grammar> findByLessonId(Long lessonId);

}

