package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.controller.base.BaseController;
import com.learning.lvtn_backend.dto.request.dtoCourse.dtoUpdateCourse;
import com.learning.lvtn_backend.dto.response.dtoGetCourse;
import com.learning.lvtn_backend.entity.Course;
import com.learning.lvtn_backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getCourses() {
        List<dtoGetCourse> courses = courseService.getAllCourses();
        return success("Lấy danh sách khóa học thành công!", courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        Course course = courseService.getCourseById(id);
        return success("Lấy thông tin khóa học thành công!", course);
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody dtoGetCourse request) {
        Course newCourse = courseService.createCourse(request);
        return created("Tạo khóa học mới thành công!", newCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody dtoUpdateCourse request) {
        dtoGetCourse updatedCourse = courseService.updateCourse(id, request);
        return success("Cập nhật khóa học thành công!", updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return success("Xóa khóa học thành công!", "Deleted course with ID = " + id);
    }
}
