package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.response.dtoSaved.dtoSaveVocabulary;
import com.learning.lvtn_backend.entity.UserSavedVocabulary;
import com.learning.lvtn_backend.service.UserSavedVocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/save")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

public class UserSavedVocabularyController {

    @Autowired
    private UserSavedVocabularyService userSavedVocabularyService;

    @GetMapping
    public List<UserSavedVocabulary> getUserSavedVocabularies() {
        return userSavedVocabularyService.getAllUserSavedVocabularies();
    }

    @GetMapping("/{id}")
    public UserSavedVocabulary getUserSavedVocabularyById(@PathVariable int id) {
        return userSavedVocabularyService.getUserSavedVocabularyById(id);
    }

    @PostMapping
    public UserSavedVocabulary createUserSavedVocabulary(@RequestBody UserSavedVocabulary savedVocab) {
        return userSavedVocabularyService.createUserSavedVocabulary(savedVocab);
    }

    @PutMapping("/{id}")
    public UserSavedVocabulary updateUserSavedVocabulary(@PathVariable int id, @RequestBody UserSavedVocabulary savedVocab) {
        return userSavedVocabularyService.updateUserSavedVocabulary(id, savedVocab);
    }

    @DeleteMapping("/{id}")
    public String deleteUserSavedVocabulary(@PathVariable int id) {
        userSavedVocabularyService.deleteUserSavedVocabulary(id);
        return "Deleted saved vocabulary with ID = " + id;
    }
    @GetMapping("/user/{id}")
    public List<dtoSaveVocabulary> getUserSavedVocabularyByUserId(@PathVariable int id) {
        return userSavedVocabularyService.getVocabSaveByUser(id);
    }
}
