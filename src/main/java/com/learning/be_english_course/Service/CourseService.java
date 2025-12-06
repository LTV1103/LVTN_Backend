package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.course.dtoCreateCourse;
import com.learning.be_english_course.DTO.request.course.dtoUpdateCourse;
import com.learning.be_english_course.DTO.respone.course.dtoCourseUser;
import com.learning.be_english_course.Entity.Course;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EntityMapping entityMapping;
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy khóa học với id = " + id));
    }
    public List<dtoCourseUser> findUserId(long userId) {
        return courseRepository.findCourseByUser(userId);
    }
    public Course createCourse(dtoCreateCourse request) {
        Course course = entityMapping.DTOtoCreateCourse(request);
        return courseRepository.save(course);
    }
    public Course updateCourse(long id,dtoUpdateCourse request) {
        Course course = courseRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thấy khóa học với id = " + id));
        entityMapping.DTOtoUpdateCourse(course,request);
        return courseRepository.save(course);
    }
    public void deleteCourse(long id) {
        if(!courseRepository.existsById(id)){
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        courseRepository.deleteById(id);
    }
}
