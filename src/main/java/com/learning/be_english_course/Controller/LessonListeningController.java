package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.lesson_listening.dtoCreateListening;
import com.learning.be_english_course.DTO.request.lesson_listening.dtoUpdateListening;
import com.learning.be_english_course.Entity.Lesson_listening;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.LessonListeningService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/listen")
public class LessonListeningController extends BaseController {

    @Autowired
    private LessonListeningService lessonListeningService;

    // Lấy tất cả bài nghe
    @GetMapping
    public ResponseEntity<ApiResponse<List<Lesson_listening>>> getAll() {
        List<Lesson_listening> listenings = lessonListeningService.findAll();
        return success("Lấy danh sách bài nghe thành công!", listenings);
    }
    @GetMapping("/lesson/{id}")
    public ResponseEntity<ApiResponse<List<Lesson_listening>>> getByLessonId(@PathVariable Long id) {
        List<Lesson_listening> listenings = lessonListeningService.findByLessonId(id);
        return success("Lấy danh sách bài nghe theo bai thành công!", listenings);
    }

    // Lấy bài nghe theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Lesson_listening>> getById(@PathVariable Long id) {
        Lesson_listening listening = lessonListeningService.findById(id);
        return success("Lấy thông tin bài nghe thành công!", listening);
    }

    // Tạo mới bài nghe
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Lesson_listening>> create(@ModelAttribute @Valid dtoCreateListening request)throws IOException {
        Lesson_listening listening = lessonListeningService.createLessonListening(request);
        return created("Tạo bài nghe mới thành công!", listening);
    }

    // Cập nhật bài nghe
    @PutMapping(value = "/{id}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Lesson_listening>> update(@PathVariable Long id,
                                                                @ModelAttribute dtoUpdateListening request)throws IOException {
        Lesson_listening listening = lessonListeningService.updateLessonListening(id, request);
        return success("Cập nhật bài nghe thành công!", listening);
    }

    // Xóa bài nghe
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        lessonListeningService.deleteLessonListening(id);
        return success("Xóa bài nghe thành công!", "ID = " + id);
    }
}
