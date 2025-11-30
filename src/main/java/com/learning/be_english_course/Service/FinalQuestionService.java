package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.final_question.dtoCreateQuestion;
import com.learning.be_english_course.DTO.request.final_question.dtoUpdateQuestion;
import com.learning.be_english_course.Entity.Final_question;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.FinalQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalQuestionService {
    @Autowired
    private FinalQuestionRepository finalQuestionRepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Final_question
    public List<Final_question> findAll() {
        return finalQuestionRepository.findAll();
    }

    // Tìm theo id
    public Final_question findById(Long id) {
        return finalQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi với id = " + id));
    }

    // Tạo mới Final_question
    public Final_question createFinalQuestion(dtoCreateQuestion request) {
        Final_question question = entityMapping.DTOtoCreateTestQuestion(request);
        return finalQuestionRepository.save(question);
    }

    // Cập nhật Final_question
    public Final_question updateFinalQuestion(Long id, dtoUpdateQuestion request) {
        Final_question question = finalQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi với id = " + id));
        entityMapping.DTOtoUpdateTestQuestion(question, request);
        return finalQuestionRepository.save(question);
    }

    // Xóa Final_question
    public void deleteFinalQuestion(Long id) {
        if (!finalQuestionRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        finalQuestionRepository.deleteById(id);
    }



}
