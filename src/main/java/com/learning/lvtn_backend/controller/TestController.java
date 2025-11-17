package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.dto.request.dtoTest.dtoCreateTest;
import com.learning.lvtn_backend.dto.request.dtoTest.dtoUpdateTest;
import com.learning.lvtn_backend.dto.response.dtoTest.dtoGetTest;
import com.learning.lvtn_backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

public class TestController extends BaseController {

    @Autowired
    private TestService testService;

    @GetMapping
    public ResponseEntity<?> getAllTests() {
        List<dtoGetTest> tests = testService.getAllTests();
        return success("Lấy danh sách bài kiểm tra thành công!", tests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestById(@PathVariable int id) {
        dtoGetTest test = testService.getTestById(id);
        return success("Lấy thông tin bài kiểm tra thành công!", test);
    }

    @PostMapping
    public ResponseEntity<?> createTest(@RequestBody dtoCreateTest request) {
        dtoGetTest newTest = testService.createTest(request);
        return created("Tạo bài kiểm tra mới thành công!", newTest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTest(@PathVariable int id, @RequestBody dtoUpdateTest request) {
        dtoGetTest updatedTest = testService.updateTest(id, request);
        return success("Cập nhật bài kiểm tra thành công!", updatedTest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable int id) {
        testService.deleteTest(id);
        return success("Xóa bài kiểm tra thành công!", "Deleted test with ID = " + id);
    }
}
