package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.lesson.dtoCreateLesson;
import com.learning.be_english_course.DTO.request.lesson.dtoUpdateLesson;
import com.learning.be_english_course.DTO.respone.lesson.dtoLesson;
import com.learning.be_english_course.Entity.Lesson;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.LessonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController extends BaseController {

    @Autowired
    private LessonService lessonService;

    // Lấy tất cả Lesson
    @GetMapping
    public ResponseEntity<ApiResponse<List<dtoLesson>>> getAllLesson() {
        List<dtoLesson> lessons = lessonService.findAll();
        return success("Lấy danh sách bài học thành công!", lessons);
    }

//    @GetMapping("/course/{id}")
//    public ResponseEntity<ApiResponse<List<dtoLesson>>> getAllLessonByCourseId(@PathVariable Long id) {
//        List<dtoLesson> dto = lessonService.getAllByCourseId(id);
//        return success("Lấy danh sách bài học thành công!", dto);
//    }

    // Lấy Lesson theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Lesson>> getLessonById(@PathVariable Long id) {
        Lesson lesson = lessonService.findById(id);
        return success("Lấy thông tin bài học thành công!", lesson);
    }

    // Tạo mới Lesson
    @PostMapping
    public ResponseEntity<ApiResponse<Lesson>> createLesson(@RequestBody @Valid dtoCreateLesson request) {
        Lesson lesson = lessonService.createLesson(request);
        return created("Tạo bài học mới thành công!", lesson);
    }

    // Cập nhật Lesson
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Lesson>> updateLesson(@PathVariable Long id,
                                                            @RequestBody @Valid dtoUpdateLesson request) {
        Lesson lesson = lessonService.updateLesson(id, request);
        return success("Cập nhật bài học thành công!", lesson);
    }

    // Xóa Lesson
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return success("Xóa bài học thành công!", "ID = " + id);
    }
}
