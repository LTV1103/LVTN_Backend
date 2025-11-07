package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoTestQuestion.dtoCreateTestQuestion;
import com.learning.lvtn_backend.dto.request.dtoTestQuestion.dtoUpdateTestQuestion;
import com.learning.lvtn_backend.dto.response.dtoTestQuestion.dtoGetTestQuestion;
import com.learning.lvtn_backend.entity.TestQuestion;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/question")
public class TestQuestionController extends BaseController {

    @Autowired
    private TestQuestionService testQuestionService;

    @GetMapping
    public ResponseEntity<?> getAllTestQuestions() {
        List<dtoGetTestQuestion> questions = testQuestionService.getAllTestQuestions();
        return success("Lấy danh sách câu hỏi thành công!", questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestQuestionById(@PathVariable int id) {
        dtoGetTestQuestion question = testQuestionService.getTestQuestionById(id);
        return success("Lấy thông tin câu hỏi thành công!", question);
    }

    @PostMapping
    public ResponseEntity<?> createTestQuestion(@RequestBody dtoCreateTestQuestion request) {
        TestQuestion newQuestion = testQuestionService.createTestQuestion(request);
        return created("Tạo câu hỏi mới thành công!", newQuestion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestQuestion(@PathVariable int id, @RequestBody dtoUpdateTestQuestion request) {
        dtoGetTestQuestion updatedQuestion = testQuestionService.updateTestQuestion(id, request);
        return success("Cập nhật câu hỏi thành công!", updatedQuestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestQuestion(@PathVariable int id) {
        testQuestionService.deleteTestQuestion(id);
        return success("Xóa câu hỏi thành công!", "Deleted test question with ID = " + id);
    }
}
