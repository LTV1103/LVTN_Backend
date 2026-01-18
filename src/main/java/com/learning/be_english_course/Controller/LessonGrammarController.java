package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.lesson_grammar.dtoCreateGrammar;
import com.learning.be_english_course.DTO.request.lesson_grammar.dtoUpdateGrammar;
import com.learning.be_english_course.Entity.Lesson_grammar;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.LessonGrammarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/grammar")
public class LessonGrammarController extends BaseController {

    @Autowired
    private LessonGrammarService lessonGrammarService;

    // Lấy tất cả bài ngữ pháp
    @GetMapping
    public ResponseEntity<ApiResponse<List<Lesson_grammar>>> getAll() {
        List<Lesson_grammar> grammars = lessonGrammarService.findAll();
        return success("Lấy danh sách bài ngữ pháp thành công!", grammars);
    }
    @GetMapping("/lesson/{id}")
    public ResponseEntity<ApiResponse<List<Lesson_grammar>>> getGrammarByLessonId(@PathVariable Long id) {
        List<Lesson_grammar> grammar = lessonGrammarService.findByLessonId(id);
        return success("Lấy danh sách bài ngữ pháp theo bai thành công!", grammar);
    }

    // Lấy bài ngữ pháp theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Lesson_grammar>> getById(@PathVariable Long id) {
        Lesson_grammar grammar = lessonGrammarService.findById(id);
        return success("Lấy thông tin bài ngữ pháp thành công!", grammar);
    }

    // Tạo mới bài ngữ pháp
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Lesson_grammar>> create(
            @ModelAttribute dtoCreateGrammar request) throws IOException {

        Lesson_grammar grammar = lessonGrammarService.createLessonGrammar(request);
        return created("Tạo bài grammar thành công!", grammar);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Lesson_grammar>> update(
            @PathVariable Long id,
            @ModelAttribute dtoUpdateGrammar request) throws IOException {

        Lesson_grammar grammar = lessonGrammarService.updateLessonGrammar(id, request);
        return success("Cập nhật grammar thành công!", grammar);
    }

    // Xóa bài ngữ pháp
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        lessonGrammarService.deleteLessonGrammar(id);
        return success("Xóa bài ngữ pháp thành công!", "ID = " + id);
    }
}
