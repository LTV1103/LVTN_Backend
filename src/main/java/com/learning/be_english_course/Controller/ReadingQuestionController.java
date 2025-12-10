package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.reading_question.dtoCreateReadQuestion;
import com.learning.be_english_course.DTO.request.reading_question.dtoUpdateReadQuestion;
import com.learning.be_english_course.Entity.Reading_question;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.ReadingQuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/read-question")
public class ReadingQuestionController extends BaseController {

    @Autowired
    private ReadingQuestionService readingQuestionService;

    // Lấy tất cả câu hỏi đọc
    @GetMapping
    public ResponseEntity<ApiResponse<List<Reading_question>>> getAll() {
        List<Reading_question> questions = readingQuestionService.findAll();
        return success("Lấy danh sách câu hỏi đọc thành công!", questions);
    }

    // Lấy câu hỏi đọc theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Reading_question>>> getById(@PathVariable Long id) {
        List<Reading_question> question = readingQuestionService.findByReadingId(id);
        return success("Lấy thông tin câu hỏi đọc thành công!", question);
    }

    // Tạo mới câu hỏi đọc
    @PostMapping
    public ResponseEntity<ApiResponse<Reading_question>> create(@RequestBody @Valid dtoCreateReadQuestion request) {
        Reading_question question = readingQuestionService.createReadingQuestion(request);
        return created("Tạo câu hỏi đọc mới thành công!", question);
    }

    // Cập nhật câu hỏi đọc
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Reading_question>> update(@PathVariable Long id,
                                                                @RequestBody @Valid dtoUpdateReadQuestion request) {
        Reading_question question = readingQuestionService.updateReadingQuestion(id, request);
        return success("Cập nhật câu hỏi đọc thành công!", question);
    }

    // Xóa câu hỏi đọc
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        readingQuestionService.deleteReadingQuestion(id);
        return success("Xóa câu hỏi đọc thành công!", "ID = " + id);
    }
}
