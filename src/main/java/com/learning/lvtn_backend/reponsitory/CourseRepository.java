package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.Course;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    boolean existsByCourseName(String courseName);
    @Query(
            value = """
        SELECT c.* 
        FROM user_course uc
        JOIN course c ON uc.id_Course = c.id_Course
        JOIN user u ON uc.id_User = u.id_User
        WHERE uc.id_User = :userId
        """,
            nativeQuery = true
    )
    List<Course> findCourseByUser(@Param("userId") int userId);



}

