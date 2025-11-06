package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.LessonGrammar;
import com.learning.lvtn_backend.reponsitory.LessonGrammarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonGrammarService {
    @Autowired
    private LessonGrammarRepository lessonGrammarRepository;
    public List<LessonGrammar> getAllLessonGrammars() { return lessonGrammarRepository.findAll(); }

    public LessonGrammar getLessonGrammarById(int id) {
        return lessonGrammarRepository.findById(id).orElseThrow(() -> new RuntimeException("Grammar not found with ID = " + id));
    }

    public LessonGrammar createLessonGrammar(LessonGrammar grammar) { return lessonGrammarRepository.save(grammar); }

    public LessonGrammar updateLessonGrammar(int id, LessonGrammar details) {
        LessonGrammar existing = getLessonGrammarById(id);
        existing.setIdLesson(details.getIdLesson());
        existing.setTitle(details.getTitle());
        existing.setExplanation(details.getExplanation());
        existing.setExample(details.getExample());
        return lessonGrammarRepository.save(existing);
    }

    public void deleteLessonGrammar(int id) {
        if (!lessonGrammarRepository.existsById(id)) throw new RuntimeException("Grammar not found with ID = " + id);
        lessonGrammarRepository.deleteById(id);
    }
}
