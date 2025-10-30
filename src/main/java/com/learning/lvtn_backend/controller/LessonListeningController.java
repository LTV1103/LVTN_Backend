package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.LessonListening;
import com.learning.lvtn_backend.service.LessonListeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/listening")
public class LessonListeningController {

    @Autowired
    private LessonListeningService lessonListeningService;

    @GetMapping
    public List<LessonListening> getLessonListenings() {
        return lessonListeningService.getAllLessonListenings();
    }

    @GetMapping("/{id}")
    public LessonListening getLessonListeningById(@PathVariable int id) {
        return lessonListeningService.getLessonListeningById(id);
    }

    @PostMapping
    public LessonListening createLessonListening(@RequestBody LessonListening listening) {
        return lessonListeningService.createLessonListening(listening);
    }

    @PutMapping("/{id}")
    public LessonListening updateLessonListening(@PathVariable int id, @RequestBody LessonListening listening) {
        return lessonListeningService.updateLessonListening(id, listening);
    }

    @DeleteMapping("/{id}")
    public String deleteLessonListening(@PathVariable int id) {
        lessonListeningService.deleteLessonListening(id);
        return "Deleted listening with ID = " + id;
    }
}
