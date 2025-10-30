package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.UserCourse;
import com.learning.lvtn_backend.reponsitory.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserCourseService {
    @Autowired
    private UserCourseRepository userCourseRepository;

    public List<UserCourse> getAllUserCourses() { return userCourseRepository.findAll(); }

    public UserCourse getUserCourseById(int id) {
        return userCourseRepository.findById(id).orElseThrow(() -> new RuntimeException("UserCourse not found with ID = " + id));
    }

    public UserCourse createUserCourse(UserCourse userCourse) { return userCourseRepository.save(userCourse); }

    public UserCourse updateUserCourse(int id, UserCourse details) {
        UserCourse existing = getUserCourseById(id);
        existing.setId_Course(details.getId_Course());
        existing.setId_User(details.getId_User());
        existing.setEnrolledAt(details.getEnrolledAt());
        existing.setStatus(details.getStatus());
        return userCourseRepository.save(existing);
    }

    public void deleteUserCourse(int id) {
        if (!userCourseRepository.existsById(id)) throw new RuntimeException("UserCourse not found with ID = " + id);
        userCourseRepository.deleteById(id);
    }
}
