package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.progress.dtoProgress;
import com.learning.be_english_course.Entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    @Query(" SELECT count(pro.lessonId) FROM Progress pro ")
    Integer totalLesson();
    @Query(" SELECT sum(pro.progressPercent) FROM Progress pro ")
    Double totalPercent ();
    @Query ("""
    SELECT NEW com.learning.be_english_course.DTO.respone.progress.dtoProgress (
        l.lessonTitle , c.courseName , pro.progressId ,uc.userId, pro.progressPercent,pro.lastAccessed,pro.status  
    )
    FROM Progress pro
    JOIN User_course  uc ON pro.userCourseId = uc.userCourseId
    JOIN Lesson  l ON pro.lessonId = l.lessonId
    JOIN Course c ON uc.courseId = c.courseId 
    WHERE uc.userId = :userId 
    """)
    List<dtoProgress> findByUserId(Long userId);
    Optional<Progress> findByUserCourseIdAndLessonId(Long userCourseId, Long lessonId);

}

