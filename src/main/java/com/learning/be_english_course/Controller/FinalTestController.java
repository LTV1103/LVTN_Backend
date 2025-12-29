package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.final_test.dtoCreateTest;
import com.learning.be_english_course.DTO.request.final_test.dtoUpdateTest;
import com.learning.be_english_course.Entity.Final_test;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.FinalTestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class FinalTestController extends BaseController {

    @Autowired
    private FinalTestService finalTestService;

    // Lấy tất cả bài kiểm tra
    @GetMapping
    public ResponseEntity<ApiResponse<List<Final_test>>> getAllFinalTest() {
        List<Final_test> tests = finalTestService.findAll();
        return success("Lấy danh sách bài kiểm tra thành công!", tests);
    }


    // Lấy bài kiểm tra theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Final_test>> getFinalTestById(@PathVariable Long id) {
        Final_test test = finalTestService.findById(id);
        return success("Lấy thông tin bài kiểm tra thành công!", test);
    }

    // Tạo mới bài kiểm tra
    @PostMapping
    public ResponseEntity<ApiResponse<Final_test>> createFinalTest(@RequestBody @Valid dtoCreateTest request) {
        Final_test test = finalTestService.createFinalTest(request);
        return created("Tạo bài kiểm tra mới thành công!", test);
    }

    // Cập nhật bài kiểm tra
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Final_test>> updateFinalTest(@PathVariable Long id,
                                                                   @RequestBody @Valid dtoUpdateTest request) {
        Final_test test = finalTestService.updateFinalTest(id, request);
        return success("Cập nhật bài kiểm tra thành công!", test);
    }

    // Xóa bài kiểm tra
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteFinalTest(@PathVariable Long id) {
        finalTestService.deleteFinalTest(id);
        return success("Xóa bài kiểm tra thành công!", "ID = " + id);
    }
}
