package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Lesson_reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonReadingRepository extends JpaRepository<Lesson_reading, Long> {
}
