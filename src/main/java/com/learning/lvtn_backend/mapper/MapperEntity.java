package com.learning.lvtn_backend.mapper;

import com.learning.lvtn_backend.dto.request.dtoCourse.dtoCreateCourse;
import com.learning.lvtn_backend.dto.request.dtoCourse.dtoUpdateCourse;
import com.learning.lvtn_backend.dto.request.dtoGrammar.dtoCreateGrammar;
import com.learning.lvtn_backend.dto.request.dtoGrammar.dtoUpdateGrammar;
import com.learning.lvtn_backend.dto.request.dtoLearningProgress.dtoCreateLearningProgress;
import com.learning.lvtn_backend.dto.request.dtoLearningProgress.dtoUpdateLearningProgress;
import com.learning.lvtn_backend.dto.request.dtoLesson.dtoCreateLesson;
import com.learning.lvtn_backend.dto.request.dtoLesson.dtoUpdateLesson;
import com.learning.lvtn_backend.dto.request.dtoListening.dtoCreateListening;
import com.learning.lvtn_backend.dto.request.dtoListening.dtoUpdateListening;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoCreatePayment;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoUpdatePayment;
import com.learning.lvtn_backend.dto.request.dtoReading.dtoCreateReading;
import com.learning.lvtn_backend.dto.request.dtoReading.dtoUpdateReading;
import com.learning.lvtn_backend.dto.request.dtoTest.dtoCreateTest;
import com.learning.lvtn_backend.dto.request.dtoTest.dtoUpdateTest;
import com.learning.lvtn_backend.dto.request.dtoTestQuestion.dtoCreateTestQuestion;
import com.learning.lvtn_backend.dto.request.dtoTestQuestion.dtoUpdateTestQuestion;
import com.learning.lvtn_backend.dto.request.dtoTestResult.dtoCreateTestResult;
import com.learning.lvtn_backend.dto.request.dtoTestResult.dtoUpdateTestResult;
import com.learning.lvtn_backend.dto.request.dtoUser.dtoCreateUsers;
import com.learning.lvtn_backend.dto.request.dtoUser.dtoUpdateUsers;
import com.learning.lvtn_backend.dto.request.dtoUserCourse.dtoCreateUserCourse;
import com.learning.lvtn_backend.dto.request.dtoUserCourse.dtoUpdateUserCourse;
import com.learning.lvtn_backend.dto.request.dtoVocabulary.dtoCreateVocabulary;
import com.learning.lvtn_backend.dto.request.dtoVocabulary.dtoUpdateVocabulary;
import com.learning.lvtn_backend.dto.response.dtoCourse.dtoGetCourse;
import com.learning.lvtn_backend.dto.response.dtoGrammar.dtoGetGrammar;
import com.learning.lvtn_backend.dto.response.dtoLearningProgress.dtoGetLearningProgress;
import com.learning.lvtn_backend.dto.response.dtoLesson.dtoGetLesson;
import com.learning.lvtn_backend.dto.response.dtoListening.dtoGetListening;
import com.learning.lvtn_backend.dto.response.dtoPayment.dtoGetPayment;
import com.learning.lvtn_backend.dto.response.dtoReading.dtoGetReading;
import com.learning.lvtn_backend.dto.response.dtoTest.dtoGetTest;
import com.learning.lvtn_backend.dto.response.dtoTestQuestion.dtoGetTestQuestion;
import com.learning.lvtn_backend.dto.response.dtoTestResult.dtoGetTestResult;
import com.learning.lvtn_backend.dto.response.dtoUser.dtoGetUser;
import com.learning.lvtn_backend.dto.response.dtoUserCourse.dtoGetUserCourse;
import com.learning.lvtn_backend.dto.response.dtoVocabulary.dtoGetVocabulary;
import com.learning.lvtn_backend.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Primary
@Mapper(componentModel = "spring")
public interface MapperEntity {

    // ================= USER =================
    User dtoCreateUserToUser(dtoCreateUsers request);
    dtoGetUser userToDtoUser(User user);
    List<dtoGetUser> listUserTolistDtoUser(List<User> users);
    void userUpdate(@MappingTarget User user , dtoUpdateUsers request);

    // ================= USER COURSE =================
    UserCourse dtoCreateUserCourseToUserCourse(dtoCreateUserCourse request);
    dtoGetUserCourse userCourseToDtoGetUserCourse(UserCourse userCourse);
    List<dtoGetUserCourse> listUserCourseToListDtoGetUserCourse(List<UserCourse> userCourses);
    void userCourseUpdate(@MappingTarget UserCourse userCourse, dtoUpdateUserCourse request);

    // ================= PAYMENT =================
    Payment dtoCreatePaymentToPayment(dtoCreatePayment request);
    dtoGetPayment paymentToDtoGetPayment(Payment payment);
    List<dtoGetPayment> listPaymentToListDtoGetPayment(List<Payment> payments);
    void paymentUpdate(@MappingTarget Payment payment, dtoUpdatePayment request);

    // ================= LEARNING PROGRESS =================
    LearningProgress dtoCreateLearningProgressToProgress(dtoCreateLearningProgress request);
    dtoGetLearningProgress progressToDtoGetLearningProgress(LearningProgress progress);
    List<dtoGetLearningProgress> listProgressToListDtoGetLearningProgress(List<LearningProgress> progresses);
    void progressUpdate(@MappingTarget LearningProgress progress, dtoUpdateLearningProgress request);

    // ================= COURSE =================
    Course dtoCreateCourseToCourse(dtoCreateCourse request);
    dtoGetCourse courseToDtoCourse(Course course);
    List<dtoGetCourse> listCourseTolistDtoCourse(List<Course> courses);
    void courseUpdate(@MappingTarget Course course , dtoUpdateCourse request);

    // ================= LESSON =================
    Lesson dtoCreateLessonToLesson(dtoCreateLesson request);
    dtoGetLesson lessonToDtoGetLesson(Lesson lesson);
    List<dtoGetLesson> listLessonToListDtoGetLesson(List<Lesson> lessons);
    void lessonUpdate(@MappingTarget Lesson lesson, dtoUpdateLesson request);

    // ================= LISTENING =================
    LessonListening dtoCreateListeningToListening(dtoCreateListening request);
    dtoGetListening listeningToDtoGetListening(LessonListening listening);
    List<dtoGetListening> listListeningToListDtoGetListening(List<LessonListening> listenings);
    void listeningUpdate(@MappingTarget LessonListening listening, dtoUpdateListening request);

    // ================= READING =================
    LessonReading dtoCreateReadingToReading(dtoCreateReading request);
    dtoGetReading readingToDtoGetReading(LessonReading reading);
    List<dtoGetReading> listReadingToListDtoGetReading(List<LessonReading> readings);
    void readingUpdate(@MappingTarget LessonReading reading, dtoUpdateReading request);

    // ================= VOCABULARY =================
    LessonVocabulary dtoCreateVocabularyToVocabulary(dtoCreateVocabulary request);
    dtoGetVocabulary vocabularyToDtoGetVocabulary(LessonVocabulary vocabulary);
    List<dtoGetVocabulary> listVocabularyToListDtoGetVocabulary(List<LessonVocabulary> vocabularies);
    void vocabularyUpdate(@MappingTarget LessonVocabulary vocabulary, dtoUpdateVocabulary request);

    // ================= GRAMMAR =================
    LessonGrammar dtoCreateGrammarToGrammar(dtoCreateGrammar request);
    dtoGetGrammar grammarToDtoGetGrammar(LessonGrammar grammar);
    List<dtoGetGrammar> listGrammarToListDtoGetGrammar(List<LessonGrammar> grammars);
    void grammarUpdate(@MappingTarget LessonGrammar grammar, dtoUpdateGrammar request);

    // ================= TEST =================
    Test dtoCreateTestToTest(dtoCreateTest request);
    dtoGetTest testToDtoGetTest(Test test);
    List<dtoGetTest> listTestToListDtoGetTest(List<Test> tests);
    void testUpdate(@MappingTarget Test test, dtoUpdateTest request);

    // ================= TEST RESULT =================
    TestResult dtoCreateTestResultToTestResult(dtoCreateTestResult request);
    dtoGetTestResult testResultToDtoGetTestResult(TestResult testResult);
    List<dtoGetTestResult> listTestResultToListDtoGetTestResult(List<TestResult> testResults);
    void testResultUpdate(@MappingTarget TestResult testResult, dtoUpdateTestResult request);

    // ================= TEST QUESTION =================
    TestQuestion dtoCreateTestQuestionToTestQuestion(dtoCreateTestQuestion request);
    dtoGetTestQuestion testQuestionToDtoGetTestQuestion(TestQuestion testQuestion);
    List<dtoGetTestQuestion> listTestQuestionToListDtoGetTestQuestion(List<TestQuestion> testQuestions);
    void testQuestionUpdate(@MappingTarget TestQuestion testQuestion, dtoUpdateTestQuestion request);
}
