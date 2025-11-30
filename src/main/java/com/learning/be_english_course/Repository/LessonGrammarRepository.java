package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Lesson_grammar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonGrammarRepository extends JpaRepository<Lesson_grammar, Long> {
}

