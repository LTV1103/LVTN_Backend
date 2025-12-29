package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.User_course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserCourseRepository extends JpaRepository<User_course, Long> {
    List<User_course> findByUserId(Long id);
    Optional<User_course> findByUserIdAndCourseId(Long UserId, Long CourseId);
}
