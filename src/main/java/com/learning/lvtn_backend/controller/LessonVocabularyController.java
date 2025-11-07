package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoVocabulary.dtoCreateVocabulary;
import com.learning.lvtn_backend.dto.request.dtoVocabulary.dtoUpdateVocabulary;
import com.learning.lvtn_backend.dto.response.dtoVocabulary.dtoGetVocabulary;
import com.learning.lvtn_backend.entity.LessonVocabulary;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.service.LessonVocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vocabulary")
public class LessonVocabularyController extends BaseController {

    @Autowired
    private LessonVocabularyService lessonVocabularyService;

    @GetMapping
    public ResponseEntity<?> getLessonVocabularies() {
        List<dtoGetVocabulary> vocabularies = lessonVocabularyService.getAllLessonVocabularies();
        return success("Lấy danh sách từ vựng thành công!", vocabularies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLessonVocabularyById(@PathVariable int id) {
        dtoGetVocabulary vocabulary = lessonVocabularyService.getLessonVocabularyById(id);
        return success("Lấy thông tin từ vựng thành công!", vocabulary);
    }

    @PostMapping
    public ResponseEntity<?> createLessonVocabulary(@RequestBody dtoCreateVocabulary request) {
        LessonVocabulary newVocabulary = lessonVocabularyService.createLessonVocabulary(request);
        return created("Tạo bài học từ vựng mới thành công!", newVocabulary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLessonVocabulary(@PathVariable int id, @RequestBody dtoUpdateVocabulary request) {
        dtoGetVocabulary updatedVocabulary = lessonVocabularyService.updateLessonVocabulary(id, request);
        return success("Cập nhật bài học từ vựng thành công!", updatedVocabulary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLessonVocabulary(@PathVariable int id) {
        lessonVocabularyService.deleteLessonVocabulary(id);
        return success("Xóa bài học từ vựng thành công!", "Deleted vocabulary with ID = " + id);
    }
}
