package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.dto.request.dtoLearningProgress.dtoCreateLearningProgress;
import com.learning.lvtn_backend.dto.request.dtoLearningProgress.dtoUpdateLearningProgress;
import com.learning.lvtn_backend.dto.response.dtoLearningProgress.dtoGetLearningProgress;
import com.learning.lvtn_backend.entity.LearningProgress;
import com.learning.lvtn_backend.service.LearningProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class LearningProgressController extends BaseController {

    @Autowired
    private LearningProgressService learningProgressService;

    @GetMapping
    public ResponseEntity<?> getAllLearningProgress() {
        List<dtoGetLearningProgress> progressList = learningProgressService.getAllLearningProgress();
        return success("Lấy danh sách tiến trình học thành công!", progressList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLearningProgressById(@PathVariable int id) {
        dtoGetLearningProgress progress = learningProgressService.getLearningProgressById(id);
        return success("Lấy thông tin tiến trình học thành công!", progress);
    }

    @PostMapping
    public ResponseEntity<?> createLearningProgress(@RequestBody dtoCreateLearningProgress request) {
        LearningProgress newProgress = learningProgressService.createLearningProgress(request);
        return created("Tạo tiến trình học mới thành công!", newProgress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLearningProgress(
            @PathVariable int id,
            @RequestBody dtoUpdateLearningProgress request
    ) {
        dtoGetLearningProgress updated = learningProgressService.updateLearningProgress(id, request);
        return success("Cập nhật tiến trình học thành công!", updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLearningProgress(@PathVariable int id) {
        learningProgressService.deleteLearningProgress(id);
        return success("Xóa tiến trình học thành công!", "Deleted learning progress with ID = " + id);
    }
}
