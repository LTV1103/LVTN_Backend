package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.LessonVocabulary;
import com.learning.lvtn_backend.service.LessonVocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vocabulary")
public class LessonVocabularyController {

    @Autowired
    private LessonVocabularyService lessonVocabularyService;

    @GetMapping
    public List<LessonVocabulary> getLessonVocabularies() {
        return lessonVocabularyService.getAllLessonVocabularies();
    }

    @GetMapping("/{id}")
    public LessonVocabulary getLessonVocabularyById(@PathVariable int id) {
        return lessonVocabularyService.getLessonVocabularyById(id);
    }

    @PostMapping
    public LessonVocabulary createLessonVocabulary(@RequestBody LessonVocabulary vocab) {
        return lessonVocabularyService.createLessonVocabulary(vocab);
    }

    @PutMapping("/{id}")
    public LessonVocabulary updateLessonVocabulary(@PathVariable int id, @RequestBody LessonVocabulary vocab) {
        return lessonVocabularyService.updateLessonVocabulary(id, vocab);
    }

    @DeleteMapping("/{id}")
    public String deleteLessonVocabulary(@PathVariable int id) {
        lessonVocabularyService.deleteLessonVocabulary(id);
        return "Deleted vocabulary with ID = " + id;
    }
}
