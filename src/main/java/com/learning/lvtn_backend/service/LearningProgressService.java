package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoLearningProgress.dtoCreateLearningProgress;
import com.learning.lvtn_backend.dto.request.dtoLearningProgress.dtoUpdateLearningProgress;
import com.learning.lvtn_backend.dto.response.dtoGetLearningProgress;
import com.learning.lvtn_backend.entity.LearningProgress;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.LearningProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LearningProgressService {

    @Autowired
    private LearningProgressRepository learningProgressRepository;
    @Autowired
    private MapperEntity learningProgressMapping;

    // Lấy tất cả progress
    public List<dtoGetLearningProgress> getAllLearningProgress() {
        List<LearningProgress> list = learningProgressRepository.findAll();
        return learningProgressMapping.dtoToGetLearningProgressList(list);
    }

    // Lấy progress theo ID
    public dtoGetLearningProgress getLearningProgressById(int id) {
        LearningProgress progress = learningProgressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tiến trình học với ID = " + id));
        return learningProgressMapping.dtoToGetLearningProgress(progress);
    }

    // Tạo mới progress
    public LearningProgress createLearningProgress(dtoCreateLearningProgress request) {
        LearningProgress progress = learningProgressMapping.progressToProgress(request);
        return learningProgressRepository.save(progress);
    }

    // Cập nhật progress
    public dtoGetLearningProgress updateLearningProgress(int id, dtoUpdateLearningProgress request) {
        LearningProgress existingProgress = learningProgressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tiến trình học với ID = " + id));

        learningProgressMapping.progressUpdate(existingProgress, request);

        LearningProgress updatedProgress = learningProgressRepository.save(existingProgress);
        return learningProgressMapping.dtoToGetLearningProgress(updatedProgress);
    }

    // Xoá progress
    public void deleteLearningProgress(int id) {
        if (!learningProgressRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy tiến trình học với ID = " + id);
        }
        learningProgressRepository.deleteById(id);
    }
}
