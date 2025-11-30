package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.listening_question.dtoCreateListenQuestion;
import com.learning.be_english_course.DTO.request.listening_question.dtoUpdateListenQuestion;
import com.learning.be_english_course.Entity.Listening_question;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.ListeningQuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listen-question")
public class ListeningQuestionController extends BaseController {

    @Autowired
    private ListeningQuestionService listeningQuestionService;

    // Lấy tất cả câu hỏi nghe
    @GetMapping
    public ResponseEntity<ApiResponse<List<Listening_question>>> getAll() {
        List<Listening_question> questions = listeningQuestionService.findAll();
        return success("Lấy danh sách câu hỏi nghe thành công!", questions);
    }

    // Lấy câu hỏi nghe theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Listening_question>> getById(@PathVariable Long id) {
        Listening_question question = listeningQuestionService.findById(id);
        return success("Lấy thông tin câu hỏi nghe thành công!", question);
    }

    // Tạo mới câu hỏi nghe
    @PostMapping
    public ResponseEntity<ApiResponse<Listening_question>> create(@RequestBody @Valid dtoCreateListenQuestion request) {
        Listening_question question = listeningQuestionService.createListeningQuestion(request);
        return created("Tạo câu hỏi nghe mới thành công!", question);
    }

    // Cập nhật câu hỏi nghe
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Listening_question>> update(@PathVariable Long id,
                                                                  @RequestBody @Valid dtoUpdateListenQuestion request) {
        Listening_question question = listeningQuestionService.updateListeningQuestion(id, request);
        return success("Cập nhật câu hỏi nghe thành công!", question);
    }

    // Xóa câu hỏi nghe
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        listeningQuestionService.deleteListeningQuestion(id);
        return success("Xóa câu hỏi nghe thành công!", "ID = " + id);
    }
}
