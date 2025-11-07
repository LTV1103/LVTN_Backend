package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoTestResult.dtoCreateTestResult;
import com.learning.lvtn_backend.dto.request.dtoTestResult.dtoUpdateTestResult;
import com.learning.lvtn_backend.dto.response.dtoTestResult.dtoGetTestResult;
import com.learning.lvtn_backend.entity.TestResult;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/result")
public class TestResultController extends BaseController {

    @Autowired
    private TestResultService testResultService;

    @GetMapping
    public ResponseEntity<?> getAllTestResults() {
        List<dtoGetTestResult> results = testResultService.getAllTestResults();
        return success("Lấy danh sách kết quả bài kiểm tra thành công!", results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestResultById(@PathVariable int id) {
        dtoGetTestResult result = testResultService.getTestResultById(id);
        return success("Lấy thông tin kết quả bài kiểm tra thành công!", result);
    }

    @PostMapping
    public ResponseEntity<?> createTestResult(@RequestBody dtoCreateTestResult request) {
        TestResult created = testResultService.createTestResult(request);
        return created("Tạo kết quả bài kiểm tra thành công!", created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestResult(@PathVariable int id, @RequestBody dtoUpdateTestResult request) {
        dtoGetTestResult updated = testResultService.updateTestResult(id, request);
        return success("Cập nhật kết quả bài kiểm tra thành công!", updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestResult(@PathVariable int id) {
        testResultService.deleteTestResult(id);
        return success("Xóa kết quả bài kiểm tra thành công!", "Deleted result with ID = " + id);
    }
}
