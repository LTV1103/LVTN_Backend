package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoGrammar.dtoCreateGrammar;
import com.learning.lvtn_backend.dto.request.dtoGrammar.dtoUpdateGrammar;
import com.learning.lvtn_backend.dto.response.dtoGrammar.dtoGetGrammar;
import com.learning.lvtn_backend.entity.LessonGrammar;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.service.LessonGrammarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/grammar")
public class LessonGrammarController extends BaseController {

    @Autowired
    private LessonGrammarService lessonGrammarService;

    @GetMapping
    public ResponseEntity<?> getLessonGrammars() {
        List<dtoGetGrammar> grammars = lessonGrammarService.getAllLessonGrammars();
        return success("Lấy danh sách ngữ pháp thành công!", grammars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLessonGrammarById(@PathVariable int id) {
        dtoGetGrammar grammar = lessonGrammarService.getLessonGrammarById(id);
        return success("Lấy chi tiết ngữ pháp thành công!", grammar);
    }

    @PostMapping
    public ResponseEntity<?> createLessonGrammar(@RequestBody dtoCreateGrammar request) {
        LessonGrammar newGrammar = lessonGrammarService.createLessonGrammar(request);
        return created("Tạo bài ngữ pháp mới thành công!", newGrammar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLessonGrammar(@PathVariable int id, @RequestBody dtoUpdateGrammar request) {
        dtoGetGrammar updated = lessonGrammarService.updateLessonGrammar(id, request);
        return success("Cập nhật bài ngữ pháp thành công!", updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLessonGrammar(@PathVariable int id) {
        lessonGrammarService.deleteLessonGrammar(id);
        return success("Xóa bài ngữ pháp thành công!", "Deleted grammar with ID = " + id);
    }
}
