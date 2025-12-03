package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.lesson.dtoCreateLesson;
import com.learning.be_english_course.DTO.request.lesson.dtoUpdateLesson;
import com.learning.be_english_course.DTO.respone.lesson.dtoLesson;
import com.learning.be_english_course.Entity.Lesson;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Lesson
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    // Tìm theo id
    public Lesson findById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học với id = " + id));
    }
    public List<dtoLesson> getAllByCourseId(Long courseId) {
        List<Lesson> lessons = lessonRepository.findByCourseId(courseId);
        return entityMapping.DTOGetLesson(lessons);
    }

    // Tạo mới Lesson
    public Lesson createLesson(dtoCreateLesson request) {
        Lesson lesson = entityMapping.DTOtoCreateLesson(request);
        return lessonRepository.save(lesson);
    }

    // Cập nhật Lesson
    public Lesson updateLesson(Long id, dtoUpdateLesson request) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học với id = " + id));
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
