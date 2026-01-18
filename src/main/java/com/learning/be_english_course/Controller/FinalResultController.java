package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.final_result.dtoCreateResult;
import com.learning.be_english_course.DTO.request.final_result.dtoUpdateResult;
import com.learning.be_english_course.DTO.respone.result.dtoResult;
import com.learning.be_english_course.Entity.Final_result;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.FinalResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class FinalResultController extends BaseController {

    @Autowired
    private FinalResultService finalResultService;

    // Lấy tất cả kết quả
    @GetMapping
    public ResponseEntity<ApiResponse<List<Final_result>>> getAllFinalResult() {
        List<Final_result> results = finalResultService.findAll();
        return success("Lấy danh sách kết quả thành công!", results);
    }


    // Lấy kết quả theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Final_result>> getFinalResultById(@PathVariable Long id) {
        Final_result result = finalResultService.findById(id);
        return success("Lấy thông tin kết quả thành công!", result);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<dtoResult>>> getResultByUserId(@PathVariable Long userId) {
       List<dtoResult> result = finalResultService.findByUserId(userId);
        return success("Lấy thông tin kết quả thành công!", result);
    }

    // Tạo mới kết quả
    @PostMapping
    public ResponseEntity<ApiResponse<Final_result>> createFinalResult(@RequestBody @Valid dtoCreateResult request) {
        Final_result result = finalResultService.createFinalResult(request);
        return created("Tạo kết quả mới thành công!", result);
    }

    // Cập nhật kết quả
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Final_result>> updateFinalResult(@PathVariable Long id,
                                                                       @RequestBody @Valid dtoUpdateResult request) {
        Final_result result = finalResultService.updateFinalResult(id, request);
        return success("Cập nhật kết quả thành công!", result);
    }

    // Xóa kết quả
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteFinalResult(@PathVariable Long id) {
        finalResultService.deleteFinalResult(id);
        return success("Xóa kết quả thành công!", "ID = " + id);
    }
}

