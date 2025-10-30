package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.LearningProgress;
import com.learning.lvtn_backend.service.LearningProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/progress")
public class LearningProgressController {

    @Autowired
    private LearningProgressService learningProgressService;

    @GetMapping
    public List<LearningProgress> getAllLearningProgress() {
        return learningProgressService.getAllLearningProgress();
    }

    @GetMapping("/{id}")
    public LearningProgress getLearningProgressById(@PathVariable int id) {
        return learningProgressService.getLearningProgressById(id);
    }

    @PostMapping
    public LearningProgress createLearningProgress(@RequestBody LearningProgress progress) {
        return learningProgressService.createLearningProgress(progress);
    }

    @PutMapping("/{id}")
    public LearningProgress updateLearningProgress(@PathVariable int id, @RequestBody LearningProgress progressDetails) {
        return learningProgressService.updateLearningProgress(id, progressDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteLearningProgress(@PathVariable int id) {
        learningProgressService.deleteLearningProgress(id);
        return "Deleted learning progress with ID = " + id;
    }
}
