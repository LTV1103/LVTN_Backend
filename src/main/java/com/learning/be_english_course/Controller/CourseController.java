package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.course.dtoCreateCourse;
import com.learning.be_english_course.DTO.request.course.dtoUpdateCourse;
import com.learning.be_english_course.DTO.respone.course.dtoCourseUser;
import com.learning.be_english_course.DTO.respone.course.dtoTotalCourseLevel;
import com.learning.be_english_course.Entity.Course;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/count")
    public ResponseEntity<ApiResponse<Integer>> count() {
        Integer count = courseService.count();
        return success("Tổng số khóa học" , count);
    }
    @GetMapping("total-level")
    public ResponseEntity<ApiResponse<List<dtoTotalCourseLevel>>> totalLevel() {
        List<dtoTotalCourseLevel> list = courseService.totalCourseLevel();
        return success("Tổng level" , list);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>>  getAllCourse() {
        List<Course> course =  courseService.findAll();
        return success("Lấy danh sách khóa học thành công!", course);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable Long id) {
        Course course = courseService.findById(id);
        return success("Lấy thông tin khóa học thành công!", course);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse<List<dtoCourseUser>>> getCourseByUserId(@PathVariable Long id) {
        List<dtoCourseUser> courseUser = courseService.findUserId(id);
        return success("Lấy thông tin khóa học thành công!", courseUser);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody @Valid dtoCreateCourse request) {
        Course course = courseService.createCourse(request);
        return created("Tạo khóa học mới thành công!", course);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Long id, @RequestBody @Valid dtoUpdateCourse request) {
        Course course = courseService.updateCourse(id, request);
        return success("Cập nhật khóa học thành công!", course);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return success("Xóa khóa học thành công!", "ID = " + id);
    }

}
