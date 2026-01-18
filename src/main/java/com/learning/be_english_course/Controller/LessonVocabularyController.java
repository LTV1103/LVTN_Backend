package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.lesson_vocabulary.dtoCreateVocabulary;
import com.learning.be_english_course.DTO.request.lesson_vocabulary.dtoUpdateVocabulary;
import com.learning.be_english_course.Entity.Lesson_vocabulary;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.LessonVocabularyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/vocabulary")
public class LessonVocabularyController extends BaseController {

    @Autowired
    private LessonVocabularyService lessonVocabularyService;

    // Lấy tất cả bài từ vựng
    @GetMapping
    public ResponseEntity<ApiResponse<List<Lesson_vocabulary>>> getAll() {
        List<Lesson_vocabulary> vocabularies = lessonVocabularyService.findAll();
        return success("Lấy danh sách bài từ vựng thành công!", vocabularies);
    }
    @GetMapping("/lesson/{id}")
    public ResponseEntity<ApiResponse<List<Lesson_vocabulary>>> findByLessonId(@PathVariable Long id) {
        List<Lesson_vocabulary> voca = lessonVocabularyService.findByLessonId(id);
        return success("DS tu vung theo bai" , voca);
    }

    // Lấy bài từ vựng theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Lesson_vocabulary>> getById(@PathVariable Long id) {
        Lesson_vocabulary vocabulary = lessonVocabularyService.findById(id);
        return success("Lấy thông tin bài từ vựng thành công!", vocabulary);
    }

    // Tạo mới bài từ vựng
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Lesson_vocabulary>> create(@ModelAttribute dtoCreateVocabulary request) throws IOException {
        Lesson_vocabulary vocabulary = lessonVocabularyService.createLessonVocabulary(request);
        return created("Tạo bài từ vựng mới thành công!", vocabulary);
    }

    // Cập nhật bài từ vựng
    @PutMapping(value = "/{id}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Lesson_vocabulary>> update(@PathVariable Long id,
                                                                 @ModelAttribute dtoUpdateVocabulary request) throws IOException {
        Lesson_vocabulary vocabulary = lessonVocabularyService.updateLessonVocabulary(id, request);
        return success("Cập nhật bài từ vựng thành công!", vocabulary);
    }

    // Xóa bài từ vựng
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        lessonVocabularyService.deleteLessonVocabulary(id);
        return success("Xóa bài từ vựng thành công!", "ID = " + id);
    }
}
