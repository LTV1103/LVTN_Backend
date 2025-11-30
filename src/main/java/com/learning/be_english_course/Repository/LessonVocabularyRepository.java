package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Lesson_vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonVocabularyRepository extends JpaRepository<Lesson_vocabulary, Long> {
}

