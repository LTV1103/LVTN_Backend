package com.learning.lvtn_backend.mapper;
import com.learning.lvtn_backend.dto.request.dtoCourse.dtoUpdateCourse;
import com.learning.lvtn_backend.dto.request.dtoLearningProgress.dtoCreateLearningProgress;
import com.learning.lvtn_backend.dto.request.dtoLearningProgress.dtoUpdateLearningProgress;
import com.learning.lvtn_backend.dto.request.dtoLesson.dtoCreateLesson;
import com.learning.lvtn_backend.dto.request.dtoLesson.dtoUpdateLesson;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoCreatePayment;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoUpdatePayment;
import com.learning.lvtn_backend.dto.request.dtoTest.dtoCreateTest;
import com.learning.lvtn_backend.dto.request.dtoTest.dtoUpdateTest;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoCreateUsers;
import com.learning.lvtn_backend.dto.request.dtoUsers.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.response.*;
import com.learning.lvtn_backend.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperEntity {

    //User
    Users userToUser(dtoCreateUsers request);
    dtoGetUser dtoToGetUser(Users users);
    List<dtoGetUser> dtoToGetUserList(List<Users> users);
    void  userUpdate(@MappingTarget dtoUpdateUsers request , Users user);


    //Course
    Course courseToCourse(dtoUpdateUsers request);
    dtoGetCourse dtoToGetCourse(Course course);
    List<dtoGetUser> dtoToGetCourseList(List<Course> courses);
    void courseUpdate(@MappingTarget dtoUpdateCourse request , Course course);


    // Learning Progress
    LearningProgress progressToProgress(dtoCreateLearningProgress request);
    dtoGetLearningProgress dtoToGetLearningProgress(LearningProgress progress);
    List<dtoGetLearningProgress> dtoToGetLearningProgressList(List<LearningProgress> progresses);
    void progressUpdate(@MappingTarget LearningProgress progress, dtoUpdateLearningProgress request);

    // Lesson
    Lesson lessonToLesson(dtoCreateLesson request);
    dtoGetLesson dtoToGetLesson(Lesson lesson);
    List<dtoGetLesson> dtoToGetLessonList(List<Lesson> lessons);
    void lessonUpdate(@MappingTarget Lesson lesson, dtoUpdateLesson request);

    // Payment
    Payment paymentToPayment(dtoCreatePayment request);
    dtoGetPayment dtoToGetPayment(Payment payment);
    List<dtoGetPayment> dtoToGetPaymentList(List<Payment> payments);
    void paymentUpdate(@MappingTarget Payment payment, dtoUpdatePayment request);

    // Test
    Test testToTest(dtoCreateTest request);
    dtoGetTest dtoToGetTest(Test test);
    List<dtoGetTest> dtoToGetTestList(List<Test> tests);
    void testUpdate(@MappingTarget Test test, dtoUpdateTest request);


}
