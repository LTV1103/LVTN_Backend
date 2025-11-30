package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.user_course.dtoCreateUserCourse;
import com.learning.be_english_course.DTO.request.user_course.dtoUpdateUserCourse;
import com.learning.be_english_course.Entity.User_course;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.UserCourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-course")
public class UserCourseController extends BaseController {

    @Autowired
    private UserCourseService userCourseService;

    // Lấy tất cả User_course
    @GetMapping
    public ResponseEntity<ApiResponse<List<User_course>>> getAll() {
        List<User_course> userCourses = userCourseService.findAll();
        return success("Lấy danh sách User_course thành công!", userCourses);
    }

    // Lấy User_course theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User_course>> getById(@PathVariable Long id) {
        User_course userCourse = userCourseService.getUserCourseById(id);
        return success("Lấy thông tin User_course thành công!", userCourse);
    }

    // Tạo mới User_course
    @PostMapping
    public ResponseEntity<ApiResponse<User_course>> create(@RequestBody @Valid dtoCreateUserCourse request) {
        User_course userCourse = userCourseService.createUserCourse(request);
        return created("Tạo User_course mới thành công!", userCourse);
    }

    // Cập nhật User_course
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User_course>> update(@PathVariable Long id,
                                                           @RequestBody @Valid dtoUpdateUserCourse request) {
        User_course userCourse = userCourseService.updateUserCourse(id, request);
        return success("Cập nhật User_course thành công!", userCourse);
    }

    // Xóa User_course
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        userCourseService.deleteUserCourse(id);
        return success("Xóa User_course thành công!", "ID = " + id);
    }
}
