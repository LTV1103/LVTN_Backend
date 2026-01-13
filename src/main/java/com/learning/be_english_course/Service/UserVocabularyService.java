package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.user_vocabulary.dtoCreateUserVocabulary;
import com.learning.be_english_course.DTO.request.user_vocabulary.dtoUpdateUserVocabulary;
import com.learning.be_english_course.DTO.respone.user_vocabulary.dtoGetSaveVocabulary;
import com.learning.be_english_course.Entity.User_vocabulary;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.UserVocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVocabularyService {
    @Autowired
    private UserVocabularyRepository userVocabularyRepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả User_vocabulary
    public List<User_vocabulary> findAll() {
        return userVocabularyRepository.findAll();
    }

    // Tìm theo id
    public User_vocabulary findById(Long id) {
        return userVocabularyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy từ vựng người dùng với id = " + id));
    }

    // ds tu vung theo nguoi dung
    public  List<dtoGetSaveVocabulary> findyUserId(Long userId) {
        return userVocabularyRepository.saveVocabulary(userId);
    }

    // Tạo mới User_vocabulary
    public User_vocabulary createUserVocabulary(dtoCreateUserVocabulary request) {
        User_vocabulary userVocabulary = entityMapping.DTOtoCreateUserVocabulary(request);
        return userVocabularyRepository.save(userVocabulary);
    }

    // Cập nhật User_vocabulary
    public User_vocabulary updateUserVocabulary(Long id, dtoUpdateUserVocabulary request) {
        User_vocabulary userVocabulary = userVocabularyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy từ vựng người dùng với id = " + id));
        entityMapping.DTOtoUpdateUserVocabulary(userVocabulary, request);
        return userVocabularyRepository.save(userVocabulary);
    }

    // Xóa User_vocabulary
    public void deleteUserVocabulary(Long id) {
        if (!userVocabularyRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        userVocabularyRepository.deleteById(id);
    }

}
