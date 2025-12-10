package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    @Query(" SELECT count(pro.lessonId) FROM Progress pro ")
    Integer totalLesson();
    @Query(" SELECT sum(pro.progressPercent) FROM Progress pro ")
    Double totalPercent ();
}
