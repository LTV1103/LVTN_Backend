package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.LessonVocabulary;
import com.learning.lvtn_backend.reponsitory.LessonVocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonVocabularyService {
    @Autowired
    private LessonVocabularyRepository lessonVocabularyRepository;

    public List<LessonVocabulary> getAllLessonVocabularies() { return lessonVocabularyRepository.findAll(); }

    public LessonVocabulary getLessonVocabularyById(int id) {
        return lessonVocabularyRepository.findById(id).orElseThrow(() -> new RuntimeException("Vocab not found with ID = " + id));
    }

    public LessonVocabulary createLessonVocabulary(LessonVocabulary vocab) { return lessonVocabularyRepository.save(vocab); }

    public LessonVocabulary updateLessonVocabulary(int id, LessonVocabulary details) {
        LessonVocabulary existing = getLessonVocabularyById(id);
        existing.setIdLesson(details.getIdLesson());
        existing.setWord(details.getWord());
        existing.setMeaning(details.getMeaning());
        existing.setExample(details.getExample());
        existing.setPronunciation(details.getPronunciation());
        existing.setAudioUrl(details.getAudioUrl());
        return lessonVocabularyRepository.save(existing);
    }

    public void deleteLessonVocabulary(int id) {
        if (!lessonVocabularyRepository.existsById(id)) throw new RuntimeException("Vocab not found with ID = " + id);
        lessonVocabularyRepository.deleteById(id);
    }
}
