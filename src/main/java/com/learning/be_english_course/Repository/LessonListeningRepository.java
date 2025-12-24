package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Lesson_listening;
import com.learning.be_english_course.Entity.Lesson_vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonListeningRepository extends JpaRepository<Lesson_listening, Long> {
    List<Lesson_listening> findByLessonId(Long lessonId);

}

