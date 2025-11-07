package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoUserCourse.dtoCreateUserCourse;
import com.learning.lvtn_backend.dto.request.dtoUserCourse.dtoUpdateUserCourse;
import com.learning.lvtn_backend.dto.response.dtoUserCourse.dtoGetUserCourse;
import com.learning.lvtn_backend.entity.UserCourse;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Autowired
    private MapperEntity mapperEntity;

    public List<dtoGetUserCourse> getAllUserCourses() {
        return mapperEntity.listUserCourseToListDtoGetUserCourse(userCourseRepository.findAll());
    }

    public dtoGetUserCourse getUserCourseById(int id) {
        UserCourse userCourse = userCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy UserCourse có ID = " + id));
        return mapperEntity.userCourseToDtoGetUserCourse(userCourse);
    }

    public dtoGetUserCourse createUserCourse(dtoCreateUserCourse request) {
        UserCourse entity = mapperEntity.dtoCreateUserCourseToUserCourse(request);
        return mapperEntity.userCourseToDtoGetUserCourse(userCourseRepository.save(entity));
    }

    public dtoGetUserCourse updateUserCourse(int id, dtoUpdateUserCourse request) {
        UserCourse existing = userCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy UserCourse có ID = " + id));
        mapperEntity.userCourseUpdate(existing, request);
        return mapperEntity.userCourseToDtoGetUserCourse(userCourseRepository.save(existing));
    }

    public void deleteUserCourse(int id) {
        if (!userCourseRepository.existsById(id))
            throw new RuntimeException("Không tìm thấy UserCourse có ID = " + id);
        userCourseRepository.deleteById(id);
    }
}
