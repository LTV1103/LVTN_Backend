package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.user_vocabulary.dtoCreateUserVocabulary;
import com.learning.be_english_course.DTO.request.user_vocabulary.dtoUpdateUserVocabulary;
import com.learning.be_english_course.DTO.respone.user_vocabulary.dtoGetSaveVocabulary;
import com.learning.be_english_course.Entity.User_vocabulary;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.UserVocabularyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/save")
public class UserVocabularyController extends BaseController {

    @Autowired
    private UserVocabularyService userVocabularyService;

    // Lấy tất cả User_vocabulary
    @GetMapping
    public ResponseEntity<ApiResponse<List<User_vocabulary>>> getAlluserVocabulary() {
        List<User_vocabulary> vocabularies = userVocabularyService.findAll();
        return success("Lấy danh sách từ vựng người dùng thành công!", vocabularies);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<dtoGetSaveVocabulary>>> getSaveByUserId(@PathVariable Long userId){
        List<dtoGetSaveVocabulary> saveVoca = userVocabularyService.findyUserId(userId);
        return success("Lấy danh sách từ vựng người dùng thành công!", saveVoca);
    }

    // Lấy User_vocabulary theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User_vocabulary>> getById(@PathVariable Long id) {
        User_vocabulary vocabulary = userVocabularyService.findById(id);
        return success("Lấy thông tin từ vựng người dùng thành công!", vocabulary);
    }

    // Tạo mới User_vocabulary
    @PostMapping
    public ResponseEntity<ApiResponse<User_vocabulary>> create(@RequestBody @Valid dtoCreateUserVocabulary request) {
        User_vocabulary vocabulary = userVocabularyService.createUserVocabulary(request);
        return created("Tạo từ vựng người dùng mới thành công!", vocabulary);
    }

    // Cập nhật User_vocabulary
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User_vocabulary>> update(@PathVariable Long id,
                                                               @RequestBody @Valid dtoUpdateUserVocabulary request) {
        User_vocabulary vocabulary = userVocabularyService.updateUserVocabulary(id, request);
        return success("Cập nhật từ vựng người dùng thành công!", vocabulary);
    }

    // Xóa User_vocabulary
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        userVocabularyService.deleteUserVocabulary(id);
        return success("Xóa từ vựng người dùng thành công!", "ID = " + id);
    }
}
