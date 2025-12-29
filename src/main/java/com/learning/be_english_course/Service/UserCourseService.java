package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.user_course.dtoCreateUserCourse;
import com.learning.be_english_course.DTO.request.user_course.dtoUpdateUserCourse;
import com.learning.be_english_course.Entity.User;
import com.learning.be_english_course.Entity.User_course;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;
    @Autowired
    private EntityMapping entityMapping;
    @Autowired
    private CourseService courseService;

    public List<User_course> findAll() {
        return userCourseRepository.findAll();
    }
    public List<User_course> getUserCourseById(long id) {
        List<User_course> userCourses =
                userCourseRepository.findByUserId(id);

        LocalDateTime now = LocalDateTime.now();

        for (User_course userCourse : userCourses) {
            long days = Duration.between(
                    userCourse.getEnrolledAt(),
                    now
            ).toDays();

            if (days > 40) {
                userCourse.setStatus("noActive");
                userCourseRepository.save(userCourse);
            }
        }
        return userCourses;
    }

    public User_course createUserCourse(dtoCreateUserCourse request) {
        User_course entity = entityMapping.DTOtoCreateUserCourse(request);
        return userCourseRepository.save(entity);
    }
    public User_course createEntiryUserCourse(User_course userCourse) {
        return userCourseRepository.save(userCourse);
    }

    public User_course updateUserCourse(long id, dtoUpdateUserCourse request) {
        User_course existing = userCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy UserCourse có ID = " + id));
        entityMapping.DTOtoUpdateUserCourse(existing, request);
        return userCourseRepository.save(existing);
    }

    public void deleteUserCourse(long id) {
        if (!userCourseRepository.existsById(id))
            throw new RuntimeException("Không tìm thấy UserCourse có ID = " + id);
        userCourseRepository.deleteById(id);
    }

}
