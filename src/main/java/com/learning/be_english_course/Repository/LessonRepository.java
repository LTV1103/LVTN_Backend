package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.lesson.dtoLesson;
import com.learning.be_english_course.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query("""
     SELECT new com.learning.be_english_course.DTO.respone.lesson.dtoLesson (
      l.lessonId,l.courseId , l.lessonTitle , l.description , c.courseName 
    )
    FROM Lesson l
    JOIN Course c ON l.courseId = c.courseId
""")
    List<dtoLesson> findAllLessons();
    Optional<Lesson> findByCourseId(Long courseId);
    boolean existsByCourseId(Long courseId);
    boolean existsByCourseIdAndLessonIdNot(Long courseId, Long lessonId);
}
