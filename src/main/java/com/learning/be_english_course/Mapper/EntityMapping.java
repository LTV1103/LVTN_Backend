package com.learning.be_english_course.Mapper;

import com.learning.be_english_course.DTO.request.course.dtoCreateCourse;
import com.learning.be_english_course.DTO.request.course.dtoUpdateCourse;
import com.learning.be_english_course.DTO.request.final_question.dtoCreateQuestion;
import com.learning.be_english_course.DTO.request.final_question.dtoUpdateQuestion;
import com.learning.be_english_course.DTO.request.final_result.dtoCreateResult;
import com.learning.be_english_course.DTO.request.final_result.dtoUpdateResult;
import com.learning.be_english_course.DTO.request.final_test.dtoCreateTest;
import com.learning.be_english_course.DTO.request.final_test.dtoUpdateTest;
import com.learning.be_english_course.DTO.request.lesson.dtoCreateLesson;
import com.learning.be_english_course.DTO.request.lesson.dtoUpdateLesson;
import com.learning.be_english_course.DTO.request.lesson_grammar.dtoCreateGrammar;
import com.learning.be_english_course.DTO.request.lesson_grammar.dtoUpdateGrammar;
import com.learning.be_english_course.DTO.request.lesson_listening.dtoCreateListening;
import com.learning.be_english_course.DTO.request.lesson_listening.dtoUpdateListening;
import com.learning.be_english_course.DTO.request.lesson_reading.dtoCreateReading;
import com.learning.be_english_course.DTO.request.lesson_reading.dtoUpdateReading;
import com.learning.be_english_course.DTO.request.lesson_vocabulary.dtoCreateVocabulary;
import com.learning.be_english_course.DTO.request.lesson_vocabulary.dtoUpdateVocabulary;
import com.learning.be_english_course.DTO.request.listening_question.dtoCreateListenQuestion;
import com.learning.be_english_course.DTO.request.listening_question.dtoUpdateListenQuestion;
import com.learning.be_english_course.DTO.request.payment.dtoCreatePayment;
import com.learning.be_english_course.DTO.request.payment.dtoUpdatePayment;
import com.learning.be_english_course.DTO.request.payment_course.dtoCreatePaymentCourse;
import com.learning.be_english_course.DTO.request.payment_course.dtoUpdatePaymentCourse;
import com.learning.be_english_course.DTO.request.progress.dtoCreateProgress;
import com.learning.be_english_course.DTO.request.progress.dtoUpdateProgress;
import com.learning.be_english_course.DTO.request.reading_question.dtoCreateReadQuestion;
import com.learning.be_english_course.DTO.request.reading_question.dtoUpdateReadQuestion;
import com.learning.be_english_course.DTO.request.user.dtoCreateUser;
import com.learning.be_english_course.DTO.request.user.dtoUpdateUser;
import com.learning.be_english_course.DTO.request.user_course.dtoCreateUserCourse;
import com.learning.be_english_course.DTO.request.user_course.dtoUpdateUserCourse;
import com.learning.be_english_course.DTO.request.user_vocabulary.dtoCreateUserVocabulary;
import com.learning.be_english_course.DTO.request.user_vocabulary.dtoUpdateUserVocabulary;
import com.learning.be_english_course.DTO.respone.lesson.dtoLesson;
import com.learning.be_english_course.DTO.respone.user.dtoOneUser;
import com.learning.be_english_course.Entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Mapper(componentModel = "spring")
public interface EntityMapping {

    //USER

    User DTOtoCreateUser(dtoCreateUser request);
    dtoOneUser DTOgetOneUser(User user);
    void DTOtoUpdateUser(@MappingTarget User User, dtoUpdateUser dtoUpdateUser);

    //COURSE
    Course DTOtoCreateCourse(dtoCreateCourse request);
    void DTOtoUpdateCourse(@MappingTarget Course Course, dtoUpdateCourse dtoUpdateCourse);

    //PAYMENT
    Payment DTOtoCreatePayment(dtoCreatePayment request);
    void DTOtoUpdatePayment(@MappingTarget Payment Payment, dtoUpdatePayment dtoUpdatePayment);

    //USER_COURSE
    User_course DTOtoCreateUserCourse(dtoCreateUserCourse request);
    void DTOtoUpdateUserCourse(@MappingTarget User_course User_course, dtoUpdateUserCourse dtoUpdateUserCourse);

    //PROGRESS
    Progress DTOtoCreateProgress(dtoCreateProgress request);
    void DTOtoUpdateProgress(@MappingTarget Progress Progress, dtoUpdateProgress dtoUpdateProgress);

    //LESSON
    // Trong class entityMapping
    default List<dtoLesson> DTOGetLesson(List<Lesson> lessons) {
        return lessons.stream()
                .map(l -> new dtoLesson(
                        l.getLessonId(),
                        l.getLessonTitle(),
                        l.getDescription(),
                        l.getOrderIndex()
                ))
                .collect(Collectors.toList());
    }

    Lesson DTOtoCreateLesson(dtoCreateLesson request);
    void DTOtoUpdateLesson(@MappingTarget Lesson Lesson, dtoUpdateLesson dtoUpdateLesson);

    //LESSON_VOCABULARY
    Lesson_vocabulary DTOtoCreateLessonVocabulary(dtoCreateVocabulary request);
    void DTOtoUpdateLessonVocabulary(@MappingTarget Lesson_vocabulary Lesson_vocabulary, dtoUpdateVocabulary dtoUpdateLessonVocabulary);

    //LESSON_GRAMMAR
    Lesson_grammar DTOtoCreateLessonGrammar(dtoCreateGrammar request);
    void DTOtoUpdateLessonGrammar(@MappingTarget Lesson_grammar Lesson_grammar, dtoUpdateGrammar dtoUpdateLessonGrammar);

    //LESSON_LISTENING
    Lesson_listening DTOtoCreateLessonListening(dtoCreateListening request);
    void DTOtoUpdateLessonListening(@MappingTarget Lesson_listening Lesson_listening, dtoUpdateListening dtoUpdateLessonListening);

    //LESSON_READING
    Lesson_reading DTOtoCreateLessonReading(dtoCreateReading request);
    void DTOtoUpdateLessonReading(@MappingTarget Lesson_reading Lesson_reading, dtoUpdateReading dtoUpdateLessonReading);

    //LISTENING_QUESTION
    Listening_question DTOtoCreateListeningQuestion(dtoCreateListenQuestion request);
    void DTOtoUpdateListeningQuestion(@MappingTarget Listening_question Listening_question, dtoUpdateListenQuestion dtoUpdateListeningQuestion);

    //READING_QUESTION
    Reading_question DTOtoCreateReadingQuestion(dtoCreateReadQuestion request);
    void DTOtoUpdateReadingQuestion(@MappingTarget Reading_question Reading_question, dtoUpdateReadQuestion dtoUpdateReadingQuestion);

    //FINAL_TEST
    Final_test DTOtoCreateTest(dtoCreateTest request);
    void DTOtoUpdateTest(@MappingTarget Final_test Final_test, dtoUpdateTest dtoUpdateFinalTest);

    //FINAL_TEST_QUESTION
    Final_question DTOtoCreateTestQuestion(dtoCreateQuestion request);
    void DTOtoUpdateTestQuestion(@MappingTarget Final_question Final_test_question, dtoUpdateQuestion dtoUpdateFinalTestQuestion);

    //TEST_RESULT
    Final_result DTOtoCreateTestResult(dtoCreateResult request);
    void DTOtoUpdateTestResult(@MappingTarget Final_result Test_result, dtoUpdateResult dtoUpdateTestResult);

    //USER_VOCABULARY
    User_vocabulary DTOtoCreateUserVocabulary(dtoCreateUserVocabulary request);
    void DTOtoUpdateUserVocabulary(@MappingTarget User_vocabulary User_vocabulary, dtoUpdateUserVocabulary dtoUpdateUserVocabulary);

    //PAYMENTCOURSE
    Payment_course DTOtoCreatePaymentCourse(dtoCreatePaymentCourse request);
    void DTOtoUpdatePaymentCourse(@MappingTarget Payment_course Payment_course, dtoUpdatePaymentCourse dtoUpdatePaymentCourse);

}
