package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.LessonReading;
import com.learning.lvtn_backend.service.LessonReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reading")
public class LessonReadingController {

    @Autowired
    private LessonReadingService lessonReadingService;

    @GetMapping
    public List<LessonReading> getLessonReadings() {
        return lessonReadingService.getAllLessonReadings();
    }

    @GetMapping("/{id}")
    public LessonReading getLessonReadingById(@PathVariable int id) {
        return lessonReadingService.getLessonReadingById(id);
    }

    @PostMapping
    public LessonReading createLessonReading(@RequestBody LessonReading reading) {
        return lessonReadingService.createLessonReading(reading);
    }

    @PutMapping("/{id}")
    public LessonReading updateLessonReading(@PathVariable int id, @RequestBody LessonReading reading) {
        return lessonReadingService.updateLessonReading(id, reading);
    }

    @DeleteMapping("/{id}")
    public String deleteLessonReading(@PathVariable int id) {
        lessonReadingService.deleteLessonReading(id);
        return "Deleted reading with ID = " + id;
    }
}
