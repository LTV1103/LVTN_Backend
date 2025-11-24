package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.response.dtoSaved.dtoSaveVocabulary;
import com.learning.lvtn_backend.entity.UserSavedVocabulary;
import com.learning.lvtn_backend.reponsitory.UserSavedVocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserSavedVocabularyService {
    @Autowired
    private UserSavedVocabularyRepository userSavedVocabularyRepository;

    public List<UserSavedVocabulary> getAllUserSavedVocabularies() { return userSavedVocabularyRepository.findAll(); }

    public UserSavedVocabulary getUserSavedVocabularyById(int id) {
        return userSavedVocabularyRepository.findById(id).orElseThrow(() -> new RuntimeException("Saved Vocabulary not found with ID = " + id));
    }

    public UserSavedVocabulary createUserSavedVocabulary(UserSavedVocabulary savedVocab) {
        return userSavedVocabularyRepository.save(savedVocab);
    }

    public UserSavedVocabulary updateUserSavedVocabulary(int id, UserSavedVocabulary details) {
        UserSavedVocabulary existing = getUserSavedVocabularyById(id);
        existing.setIdUser(details.getIdUser());
        existing.setIdVocab(details.getIdVocab());
        existing.setSavedAt(details.getSavedAt());
        return userSavedVocabularyRepository.save(existing);
    }

    public void deleteUserSavedVocabulary(int id) {
        if (!userSavedVocabularyRepository.existsById(id)) throw new RuntimeException("Saved Vocabulary not found with ID = " + id);
        userSavedVocabularyRepository.deleteById(id);
    }

    public List<dtoSaveVocabulary> getVocabSaveByUser(int iduser){
        if(!userSavedVocabularyRepository.existsById(iduser)){
            throw new RuntimeException("Saved Vocabulary not found with ID = " + iduser);
        }
        return userSavedVocabularyRepository.findVocabByUserID(iduser);
    }
}
