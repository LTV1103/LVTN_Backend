package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Lesson_reading;
import com.learning.be_english_course.Entity.Lesson_vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonReadingRepository extends JpaRepository<Lesson_reading, Long> {
    List<Lesson_reading> findByLessonId(Long lessonId);

}
