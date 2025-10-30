package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.LearningProgress;
import com.learning.lvtn_backend.reponsitory.LearningProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LearningProgressService {
    @Autowired
    private LearningProgressRepository learningProgressRepository;

    public List<LearningProgress> getAllLearningProgress() { return learningProgressRepository.findAll(); }

    public LearningProgress getLearningProgressById(int id) {
        return learningProgressRepository.findById(id).orElseThrow(() -> new RuntimeException("Progress not found with ID = " + id));
    }

    public LearningProgress createLearningProgress(LearningProgress progress) { return learningProgressRepository.save(progress); }

    public LearningProgress updateLearningProgress(int id, LearningProgress details) {
        LearningProgress existing = getLearningProgressById(id);
        existing.setIdUserCourse(details.getIdUserCourse());
        existing.setIdLesson(details.getIdLesson());
        existing.setProgressPercent(details.getProgressPercent());
        existing.setLastAccessed(details.getLastAccessed());
        existing.setStatus(details.getStatus());
        return learningProgressRepository.save(existing);
    }

    public void deleteLearningProgress(int id) {
        if (!learningProgressRepository.existsById(id)) throw new RuntimeException("Progress not found with ID = " + id);
        learningProgressRepository.deleteById(id);
    }
}
