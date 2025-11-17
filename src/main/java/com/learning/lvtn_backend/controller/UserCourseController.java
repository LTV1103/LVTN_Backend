package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoUserCourse.dtoCreateUserCourse;
import com.learning.lvtn_backend.dto.request.dtoUserCourse.dtoUpdateUserCourse;
import com.learning.lvtn_backend.dto.response.dtoUserCourse.dtoGetUserCourse;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/buy")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

public class UserCourseController extends BaseController {

    @Autowired
    private UserCourseService userCourseService;

    @GetMapping
    public ResponseEntity<?> getAllUserCourses() {
        List<dtoGetUserCourse> list = userCourseService.getAllUserCourses();
        return success("Lấy danh sách khóa học đã mua thành công!", list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserCourseById(@PathVariable int id) {
        dtoGetUserCourse userCourse = userCourseService.getUserCourseById(id);
        return success("Lấy thông tin khóa học đã mua thành công!", userCourse);
    }

    @PostMapping
    public ResponseEntity<?> createUserCourse(@RequestBody dtoCreateUserCourse request) {
        dtoGetUserCourse created = userCourseService.createUserCourse(request);
        return created("Mua khóa học thành công!", created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserCourse(@PathVariable int id, @RequestBody dtoUpdateUserCourse request) {
        dtoGetUserCourse updated = userCourseService.updateUserCourse(id, request);
        return success("Cập nhật thông tin khóa học đã mua thành công!", updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserCourse(@PathVariable int id) {
        userCourseService.deleteUserCourse(id);
        return success("Xóa khóa học đã mua thành công!", "Deleted user-course with ID = " + id);
    }
}
