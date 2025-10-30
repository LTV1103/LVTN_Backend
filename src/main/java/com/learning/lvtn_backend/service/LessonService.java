package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.Lesson;
import com.learning.lvtn_backend.reponsitory.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() { return lessonRepository.findAll(); }

    public Lesson getLessonById(int id) {
        return lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found with ID = " + id));
    }

    public Lesson createLesson(Lesson lesson) { return lessonRepository.save(lesson); }

    public Lesson updateLesson(int id, Lesson details) {
        Lesson existing = getLessonById(id);
        existing.setIdCourse(details.getIdCourse());
        existing.setLessonTitle(details.getLessonTitle());
        existing.setDescription(details.getDescription());
        existing.setOrderIndex(details.getOrderIndex());
        existing.setCreatedAt(details.getCreatedAt());
        return lessonRepository.save(existing);
    }

    public void deleteLesson(int id) {
        if (!lessonRepository.existsById(id)) throw new RuntimeException("Lesson not found with ID = " + id);
        lessonRepository.deleteById(id);
    }
}
