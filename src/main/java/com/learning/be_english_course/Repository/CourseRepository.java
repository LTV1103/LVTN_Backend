package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.course.dtoCourseUser;
import com.learning.be_english_course.DTO.respone.course.dtoTotalCourseLevel;
import com.learning.be_english_course.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> , JpaSpecificationExecutor<Course> {
    boolean existsByCourseName(String name);
    boolean existsByCourseNameAndCourseIdNot(String courseName, Long courseId);
    List<Course> findTop10ByCourseNameContainingIgnoreCase(String keyword);

    @Query("""
    SELECT new com.learning.be_english_course.DTO.respone.course.dtoCourseUser (
        c.courseId, c.courseName, c.description, c.imgUrl, c.price, c.level, uc.status
    )
    FROM User_course uc
    JOIN Course c ON uc.courseId = c.courseId
    JOIN User u ON uc.userId = u.userId
    WHERE u.userId = :userId
""")
    List<dtoCourseUser> findCourseByUser(@Param("userId") Long userId);

    @Query(value = """
        SELECT c.level AS level,
               COUNT(*) AS total
        FROM Course c
        GROUP BY c.level
        ORDER BY c.level
        """, nativeQuery = true)
    List<dtoTotalCourseLevel> courselevel();

    @Query(value = "SELECT * FROM course ORDER BY RAND() LIMIT 8", nativeQuery = true)
    List<Course> findRandom8Courses();


}
