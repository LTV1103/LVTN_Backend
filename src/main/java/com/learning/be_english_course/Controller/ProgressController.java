package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.progress.dtoCreateProgress;
import com.learning.be_english_course.DTO.request.progress.dtoUpdateProgress;
import com.learning.be_english_course.DTO.respone.progress.dtoProgress;
import com.learning.be_english_course.Entity.Progress;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController extends BaseController {

    @Autowired
    private ProgressService progressService;

    // Lấy tất cả Progress
    @GetMapping
    public ResponseEntity<ApiResponse<List<Progress>>> getAll() {
        List<Progress> progresses = progressService.findAll();
        return success("Lấy danh sách tiến trình thành công!", progresses);
    }
    @GetMapping("/rate")
    public ResponseEntity<ApiResponse<Double>> finishLesson() {
        Double CompletionRate = progressService.finishLesson();
        return success("tien trinh trung binh" , CompletionRate);
    }
    // Lấy Progress theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Progress>> getById(@PathVariable Long id) {
        Progress progress = progressService.findById(id);
        return success("Lấy thông tin tiến trình thành công!", progress);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse<List<dtoProgress>>> getByUserId(@PathVariable Long id) {
        List<dtoProgress> progresses = progressService.findByUserId(id);
        return success("Lay thong tin theo nguoi dung" , progresses);
    }

    // Tạo mới Progress
    @PostMapping
    public ResponseEntity<ApiResponse<Progress>> create(@RequestBody @Valid dtoCreateProgress request) {
        Progress progress = progressService.createProgressIfNotExist(request);
        return created("Tạo tiến trình mới thành công!", progress);
    }

    // Cập nhật Progress
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Progress>> update(@PathVariable Long id,
                                                        @RequestBody @Valid dtoUpdateProgress request) {
        Progress progress = progressService.updateProgress(id, request);
        return success("Cập nhật tiến trình thành công!", progress);
    }

    // Xóa Progress
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        progressService.deleteProgress(id);
        return success("Xóa tiến trình thành công!", "ID = " + id);
    }

}
