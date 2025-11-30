package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Lesson_listening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonListeningRepository extends JpaRepository<Lesson_listening, Long> {
}

