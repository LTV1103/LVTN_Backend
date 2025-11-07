package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoReading.dtoCreateReading;
import com.learning.lvtn_backend.dto.request.dtoReading.dtoUpdateReading;
import com.learning.lvtn_backend.dto.response.dtoReading.dtoGetReading;
import com.learning.lvtn_backend.entity.LessonReading;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.service.LessonReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reading")
public class LessonReadingController extends BaseController {

    @Autowired
    private LessonReadingService lessonReadingService;

    @GetMapping
    public ResponseEntity<?> getLessonReadings() {
        List<dtoGetReading> readings = lessonReadingService.getAllLessonReadings();
        return success("Lấy danh sách bài đọc thành công!", readings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLessonReadingById(@PathVariable int id) {
        dtoGetReading reading = lessonReadingService.getLessonReadingById(id);
        return success("Lấy thông tin bài đọc thành công!", reading);
    }

    @PostMapping
    public ResponseEntity<?> createLessonReading(@RequestBody dtoCreateReading request) {
        LessonReading newReading = lessonReadingService.createLessonReading(request);
        return created("Tạo bài đọc mới thành công!", newReading);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLessonReading(@PathVariable int id, @RequestBody dtoUpdateReading request) {
        dtoGetReading updated = lessonReadingService.updateLessonReading(id, request);
        return success("Cập nhật bài đọc thành công!", updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLessonReading(@PathVariable int id) {
        lessonReadingService.deleteLessonReading(id);
        return success("Xóa bài đọc thành công!", "Deleted reading with ID = " + id);
    }
}
