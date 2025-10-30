package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.UserCourse;
import com.learning.lvtn_backend.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/buy")
public class UserCourseController {
    @Autowired
    private UserCourseService userCourseService;

    @GetMapping
    public List<UserCourse> getAllUserCourses() {
        return userCourseService.getAllUserCourses();
    }

    @GetMapping("/{id}")
    public UserCourse getUserCourseById(@PathVariable int id) {
        return userCourseService.getUserCourseById(id);
    }

    @PostMapping
    public UserCourse createUserCourse(@RequestBody UserCourse userCourse) {
        return userCourseService.createUserCourse(userCourse);
    }

    @PutMapping("/{id}")
    public UserCourse updateUserCourse(@PathVariable int id, @RequestBody UserCourse userCourseDetails) {
        return userCourseService.updateUserCourse(id, userCourseDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteUserCourse(@PathVariable int id) {
        userCourseService.deleteUserCourse(id);
        return "Deleted user-course with ID = " + id;
    }
}
