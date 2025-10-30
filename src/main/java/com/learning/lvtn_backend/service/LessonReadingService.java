package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.LessonReading;
import com.learning.lvtn_backend.reponsitory.LessonReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonReadingService {
    @Autowired
    private LessonReadingRepository lessonReadingRepository;

    public List<LessonReading> getAllLessonReadings() { return lessonReadingRepository.findAll(); }

    public LessonReading getLessonReadingById(int id) {
        return lessonReadingRepository.findById(id).orElseThrow(() -> new RuntimeException("Reading not found with ID = " + id));
    }

    public LessonReading createLessonReading(LessonReading reading) { return lessonReadingRepository.save(reading); }

    public LessonReading updateLessonReading(int id, LessonReading details) {
        LessonReading existing = getLessonReadingById(id);
        existing.setIdLesson(details.getIdLesson());
        existing.setPassage(details.getPassage());
        existing.setQuestion(details.getQuestion());
        existing.setOptionA(details.getOptionA());
        existing.setOptionB(details.getOptionB());
        existing.setOptionC(details.getOptionC());
        existing.setOptionD(details.getOptionD());
        existing.setCorrectOption(details.getCorrectOption());
        return lessonReadingRepository.save(existing);
    }

    public void deleteLessonReading(int id) {
        if (!lessonReadingRepository.existsById(id)) throw new RuntimeException("Reading not found with ID = " + id);
        lessonReadingRepository.deleteById(id);
    }
}
