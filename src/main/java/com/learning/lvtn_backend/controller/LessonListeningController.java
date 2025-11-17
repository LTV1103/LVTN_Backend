package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoListening.dtoCreateListening;
import com.learning.lvtn_backend.dto.request.dtoListening.dtoUpdateListening;
import com.learning.lvtn_backend.dto.response.dtoListening.dtoGetListening;
import com.learning.lvtn_backend.entity.LessonListening;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.service.LessonListeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/listening")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

public class LessonListeningController extends BaseController {

    @Autowired
    private LessonListeningService lessonListeningService;

    // GET ALL
    @GetMapping
    public ResponseEntity<?> getLessonListenings() {
        List<dtoGetListening> listenings = lessonListeningService.getAllLessonListenings();
        return success("Lấy danh sách bài nghe thành công!", listenings);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getLessonListeningById(@PathVariable int id) {
        dtoGetListening listening = lessonListeningService.getLessonListeningById(id);
        return success("Lấy thông tin bài nghe thành công!", listening);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<?> createLessonListening(@RequestBody dtoCreateListening request) {
        LessonListening newListening = lessonListeningService.createLessonListening(request);
        return created("Tạo bài nghe mới thành công!", newListening);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLessonListening(@PathVariable int id, @RequestBody dtoUpdateListening request) {
        dtoGetListening updated = lessonListeningService.updateLessonListening(id, request);
        return success("Cập nhật bài nghe thành công!", updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLessonListening(@PathVariable int id) {
        lessonListeningService.deleteLessonListening(id);
        return success("Xóa bài nghe thành công!", "Deleted listening with ID = " + id);
    }
}
