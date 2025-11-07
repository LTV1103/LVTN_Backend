package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.dto.request.dtoLesson.dtoCreateLesson;
import com.learning.lvtn_backend.dto.request.dtoLesson.dtoUpdateLesson;
import com.learning.lvtn_backend.dto.response.dtoLesson.dtoGetLesson;
import com.learning.lvtn_backend.entity.Lesson;
import com.learning.lvtn_backend.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController extends BaseController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public ResponseEntity<?> getAllLessons() {
        List<dtoGetLesson> lessons = lessonService.getAllLessons();
        return success("Lấy danh sách bài học thành công!", lessons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLessonById(@PathVariable int id) {
        dtoGetLesson lesson = lessonService.getLessonById(id);
        return success("Lấy thông tin bài học thành công!", lesson);
    }

    @PostMapping
    public ResponseEntity<?> createLesson(@RequestBody dtoCreateLesson request) {
        Lesson newLesson = lessonService.createLesson(request);
        return created("Tạo bài học mới thành công!", newLesson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLesson(@PathVariable int id, @RequestBody dtoUpdateLesson request) {
        dtoGetLesson updatedLesson = lessonService.updateLesson(id, request);
        return success("Cập nhật bài học thành công!", updatedLesson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLesson(@PathVariable int id) {
        lessonService.deleteLesson(id);
        return success("Xóa bài học thành công!", "Deleted lesson with ID = " + id);
    }
}
