package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.lesson.dtoLesson;
import com.learning.be_english_course.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourseId(Long courseId);

}
