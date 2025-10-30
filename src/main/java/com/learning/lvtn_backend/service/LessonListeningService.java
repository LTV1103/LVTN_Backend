package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.LessonListening;
import com.learning.lvtn_backend.reponsitory.LessonListeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonListeningService {
    @Autowired
    private LessonListeningRepository lessonListeningRepository;

    public List<LessonListening> getAllLessonListenings() { return lessonListeningRepository.findAll(); }

    public LessonListening getLessonListeningById(int id) {
        return lessonListeningRepository.findById(id).orElseThrow(() -> new RuntimeException("Listening not found with ID = " + id));
    }

    public LessonListening createLessonListening(LessonListening listening) { return lessonListeningRepository.save(listening); }

    public LessonListening updateLessonListening(int id, LessonListening details) {
        LessonListening existing = getLessonListeningById(id);
        existing.setIdLesson(details.getIdLesson());
        existing.setAudioUrl(details.getAudioUrl());
        existing.setTranscript(details.getTranscript());
        existing.setQuestion(details.getQuestion());
        existing.setOptionA(details.getOptionA());
        existing.setOptionB(details.getOptionB());
        existing.setOptionC(details.getOptionC());
        existing.setOptionD(details.getOptionD());
        existing.setCorrectOption(details.getCorrectOption());
        return lessonListeningRepository.save(existing);
    }

    public void deleteLessonListening(int id) {
        if (!lessonListeningRepository.existsById(id)) throw new RuntimeException("Listening not found with ID = " + id);
        lessonListeningRepository.deleteById(id);
    }
}
