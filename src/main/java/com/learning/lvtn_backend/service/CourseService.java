package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoCourse.dtoUpdateCourse;
import com.learning.lvtn_backend.dto.response.dtoGetCourse;
import com.learning.lvtn_backend.entity.Course;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.CourseRepository;
import com.learning.lvtn_backend.reponsitory.UsersReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UsersReponsitory usersReponsitory;
    @Autowired
    private MapperEntity courseMapping;


    public List<dtoGetCourse> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        return courseMapping.dtoToGetCourseList(courseList);
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học với ID = " + id));
    }

    public Course createCourse(dtoGetCourse request) {
        if (courseRepository.existsByCourseName(request.getCourseName())) {
            throw new RuntimeException("Tên khóa học đã tồn tại");
        }
        Course course = courseMapping.courseToCourse(request);
        return courseRepository.save(course);
    }

    public dtoGetCourse updateCourse(int id, dtoUpdateCourse request) {
        Course courseEntity = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học với ID = " + id));
        courseMapping.courseUpdate(courseEntity,request);
       Course updatedCourse = courseRepository.save(courseEntity);
       return courseMapping.dtoToGetCourse(updatedCourse);
    }

    public void deleteCourse(int id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy khóa học với ID = " + id);
        }
        courseRepository.deleteById(id);
    }

    public List<Course> getCoursebyUserid(int userId) {
        if (!usersReponsitory.existsById(userId)) {
            throw new RuntimeException("Khóa học không có người dùng với ID = " + userId);
        }
        List<Course> courseList =  courseRepository.findCourseByUser(userId);
        if (courseList.isEmpty()) {
            throw new RuntimeException("Người dùng này chưa tham gia khóa học nào!");
        }
        return courseList;
    }
}
