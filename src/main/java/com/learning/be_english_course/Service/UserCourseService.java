package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.user_course.dtoCreateUserCourse;
import com.learning.be_english_course.DTO.request.user_course.dtoUpdateUserCourse;
import com.learning.be_english_course.Entity.User_course;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;
    @Autowired
    private EntityMapping entityMapping;

    public List<User_course> findAll() {
        return userCourseRepository.findAll();
    }
    public User_course getUserCourseById(long id) {
        return userCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy UserCourse có ID = " + id));
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
