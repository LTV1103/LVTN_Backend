package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoLesson.dtoCreateLesson;
import com.learning.lvtn_backend.dto.request.dtoLesson.dtoUpdateLesson;
import com.learning.lvtn_backend.dto.response.dtoGetLesson;
import com.learning.lvtn_backend.entity.Lesson;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    private MapperEntity mapper; // Dùng chung mapper cho project

    public List<dtoGetLesson> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return mapper.dtoToGetLessonList(lessons);
    }

    public dtoGetLesson getLessonById(int id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học với ID = " + id));
        return mapper.dtoToGetLesson(lesson);
    }

    public Lesson createLesson(dtoCreateLesson request) {
        Lesson lesson = mapper.lessonToLesson(request);
        return lessonRepository.save(lesson);
    }

    public dtoGetLesson updateLesson(int id, dtoUpdateLesson request) {
        Lesson existingLesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học với ID = " + id));

        mapper.lessonUpdate(existingLesson, request);
        Lesson updatedLesson = lessonRepository.save(existingLesson);
        return mapper.dtoToGetLesson(updatedLesson);
    }

    public void deleteLesson(int id) {
        if (!lessonRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy bài học với ID = " + id);
        }
        lessonRepository.deleteById(id);
    }
}
