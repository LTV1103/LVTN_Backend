package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.final_question.dtoCreateQuestion;
import com.learning.be_english_course.DTO.request.final_question.dtoUpdateQuestion;
import com.learning.be_english_course.Entity.Final_question;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.FinalQuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test-question")
public class FinalQuestionController extends BaseController {

    @Autowired
    private FinalQuestionService finalQuestionService;

    // Lấy tất cả câu hỏi cuối kỳ
    @GetMapping
    public ResponseEntity<ApiResponse<List<Final_question>>> getAllFinalQuestion() {
        List<Final_question> questions = finalQuestionService.findAll();
        return success("Lấy danh sách câu hỏi cuối kỳ thành công!", questions);
    }

    // Lấy câu hỏi theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Final_question>> getFinalQuestionById(@PathVariable Long id) {
        Final_question question = finalQuestionService.findById(id);
        return success("Lấy thông tin câu hỏi thành công!", question);
    }

    // Tạo mới câu hỏi
    @PostMapping
    public ResponseEntity<ApiResponse<Final_question>> createFinalQuestion(@RequestBody @Valid dtoCreateQuestion request) {
        Final_question question = finalQuestionService.createFinalQuestion(request);
        return created("Tạo câu hỏi mới thành công!", question);
    }

    // Cập nhật câu hỏi
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Final_question>> updateFinalQuestion(@PathVariable Long id,
                                                                           @RequestBody @Valid dtoUpdateQuestion request) {
        Final_question question = finalQuestionService.updateFinalQuestion(id, request);
        return success("Cập nhật câu hỏi thành công!", question);
    }

    // Xóa câu hỏi
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteFinalQuestion(@PathVariable Long id) {
        finalQuestionService.deleteFinalQuestion(id);
        return success("Xóa câu hỏi thành công!", "ID = " + id);
    }
}
