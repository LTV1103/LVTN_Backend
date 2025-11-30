package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.User_course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends JpaRepository<User_course, Long> {
}
