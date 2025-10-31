package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.Course;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private MapperEntity mapperEntity;


    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID = " + id));
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(int id, Course courseDetails) {
        Course existingCourse = getCourseById(id);
        existingCourse.setCourseName(courseDetails.getCourseName());
        existingCourse.setDescription(courseDetails.getDescription());
        existingCourse.setImgUrl(courseDetails.getImgUrl());
        existingCourse.setPrice(courseDetails.getPrice());
        existingCourse.setLevel(courseDetails.getLevel());
        existingCourse.setStatus(courseDetails.getStatus());
        existingCourse.setCreatedAt(courseDetails.getCreatedAt());
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(int id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with ID = " + id);
        }
        courseRepository.deleteById(id);
    }
}
