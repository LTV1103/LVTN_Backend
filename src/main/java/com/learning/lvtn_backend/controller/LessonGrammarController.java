package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.LessonGrammar;
import com.learning.lvtn_backend.service.LessonGrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/grammar")
public class LessonGrammarController {

    @Autowired
    private LessonGrammarService lessonGrammarService;

    @GetMapping
    public List<LessonGrammar> getLessonGrammars() {
        return lessonGrammarService.getAllLessonGrammars();
    }

    @GetMapping("/{id}")
    public LessonGrammar getLessonGrammarById(@PathVariable int id) {
        return lessonGrammarService.getLessonGrammarById(id);
    }

    @PostMapping
    public LessonGrammar createLessonGrammar(@RequestBody LessonGrammar grammar) {
        return lessonGrammarService.createLessonGrammar(grammar);
    }

    @PutMapping("/{id}")
    public LessonGrammar updateLessonGrammar(@PathVariable int id, @RequestBody LessonGrammar grammar) {
        return lessonGrammarService.updateLessonGrammar(id, grammar);
    }

    @DeleteMapping("/{id}")
    public String deleteLessonGrammar(@PathVariable int id) {
        lessonGrammarService.deleteLessonGrammar(id);
        return "Deleted grammar with ID = " + id;
    }
}
