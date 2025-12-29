package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.lesson.dtoCreateLesson;
import com.learning.be_english_course.DTO.request.lesson.dtoUpdateLesson;
import com.learning.be_english_course.DTO.respone.lesson.dtoLesson;
import com.learning.be_english_course.Entity.Course;
import com.learning.be_english_course.Entity.Lesson;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Lesson
    public List<dtoLesson> findAll() {
        return lessonRepository.findAllLessons();
    }

    // Tìm theo id
    public Lesson findById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học với id = " + id));
    }
    public Optional<Lesson> getAllByCourseId(Long courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    // Tạo mới Lesson
    public Lesson createLesson(dtoCreateLesson request) {
        if (request.getCourseId() == null) {
            throw new RuntimeException("Bài học bắt buộc phải thuộc 1 khóa học");
        }
        if (lessonRepository.existsByCourseId(request.getCourseId())) {
            throw new RuntimeException(
                    "Khóa học này đã có bài học, vui lòng chọn khóa học khác"
            );
        }
        Lesson lesson = entityMapping.DTOtoCreateLesson(request);
        return lessonRepository.save(lesson);
    }



    // Cập nhật Lesson
    public Lesson updateLesson(Long id, dtoUpdateLesson request) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy bài học với id = " + id)
                );
        if (request.getCourseId() != null) {
            boolean courseUsedByOtherLesson =
                    lessonRepository.existsByCourseIdAndLessonIdNot(
                            request.getCourseId(), id
                    );
            if (courseUsedByOtherLesson) {
                throw new RuntimeException(
                        "Khóa học này đã được gán cho bài học khác"
                );
            }
        }
        entityMapping.DTOtoUpdateLesson(lesson, request);
        return lessonRepository.save(lesson);
    }



    // Xóa Lesson
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        lessonRepository.deleteById(id);
    }

}
