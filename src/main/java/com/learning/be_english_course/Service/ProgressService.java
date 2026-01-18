package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.progress.dtoCreateProgress;
import com.learning.be_english_course.DTO.request.progress.dtoUpdateProgress;
import com.learning.be_english_course.DTO.respone.progress.dtoProgress;
import com.learning.be_english_course.Entity.Progress;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Progress
    public List<Progress> findAll() {
        return progressRepository.findAll();
    }
    public Double finishLesson() {
        Double totalProgress = progressRepository.totalPercent();
        Integer countLesson = progressRepository.totalLesson();

        if (countLesson == null || countLesson == 0) return 0.0;
        if (totalProgress == null) return 0.0;
        double systemCompletionRate = totalProgress / countLesson;

        return systemCompletionRate;
    }
    //Tim theo nguoi dung
    public List<dtoProgress> findByUserId(Long userId) {
        return progressRepository.findByUserId(userId);
    }

    // Tìm theo id
    public Progress findById(Long id) {
        return progressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tiến trình với id = " + id));
    }

    // Tạo mới Progress
    public Progress createProgressIfNotExist(dtoCreateProgress request) {
        Optional<Progress> existing =
                progressRepository.findByUserCourseIdAndLessonId(
                        request.getUserCourseId(),
                        request.getLessonId()
                );

        if (existing.isPresent()) {
            return existing.get(); // đã có thì trả về luôn
        }

        Progress progress = entityMapping.DTOtoCreateProgress(request);
        progress.setLastAccessed(LocalDateTime.now());
        progress.setStatus("learning");

        return progressRepository.save(progress);
    }


    // Cập nhật Progress
    public Progress updateProgress(Long id, dtoUpdateProgress request) {
        Progress progress = progressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Không tìm thấy tiến trình với id = " + id
                ));

        entityMapping.DTOtoUpdateProgress(progress, request);
        return progressRepository.save(progress);
    }


    // Xóa Progress
    public void deleteProgress(Long id) {
        if (!progressRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        progressRepository.deleteById(id);
    }

}
