package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.lesson_reading.dtoCreateReading;
import com.learning.be_english_course.DTO.request.lesson_reading.dtoUpdateReading;
import com.learning.be_english_course.Entity.Lesson_reading;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.LessonReadingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/read")
public class LessonReadingController extends BaseController {

    @Autowired
    private LessonReadingService lessonReadingService;

    // Lấy tất cả bài đọc
    @GetMapping
    public ResponseEntity<ApiResponse<List<Lesson_reading>>> getAll() {
        List<Lesson_reading> readings = lessonReadingService.findAll();
        return success("Lấy danh sách bài đọc thành công!", readings);
    }

    // Lấy bài đọc theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Lesson_reading>> getById(@PathVariable Long id) {
        Lesson_reading reading = lessonReadingService.findById(id);
        return success("Lấy thông tin bài đọc thành công!", reading);
    }

    // Tạo mới bài đọc
    @PostMapping
    public ResponseEntity<ApiResponse<Lesson_reading>> create(@RequestBody @Valid dtoCreateReading request) {
        Lesson_reading reading = lessonReadingService.createLessonReading(request);
        return created("Tạo bài đọc mới thành công!", reading);
    }

    // Cập nhật bài đọc
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Lesson_reading>> update(@PathVariable Long id,
                                                              @RequestBody @Valid dtoUpdateReading request) {
        Lesson_reading reading = lessonReadingService.updateLessonReading(id, request);
        return success("Cập nhật bài đọc thành công!", reading);
    }

    // Xóa bài đọc
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        lessonReadingService.deleteLessonReading(id);
        return success("Xóa bài đọc thành công!", "ID = " + id);
    }
}
