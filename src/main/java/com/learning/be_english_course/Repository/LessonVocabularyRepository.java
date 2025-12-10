package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Lesson_reading;
import com.learning.be_english_course.Entity.Lesson_vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonVocabularyRepository extends JpaRepository<Lesson_vocabulary, Long> {
//    @Query"""
//    """
//    List<Lesson_reading> findAll();

}

