package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.listening_question.dtoCreateListenQuestion;
import com.learning.be_english_course.DTO.request.listening_question.dtoUpdateListenQuestion;
import com.learning.be_english_course.Entity.Listening_question;
import com.learning.be_english_course.Entity.Reading_question;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.ListeningQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListeningQuestionService {
    @Autowired
    private ListeningQuestionRepository listeningQuestionRepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Listening_question
    public List<Listening_question> findAll() {
        return listeningQuestionRepository.findAll();
    }

    // Tìm theo id
    public Listening_question findById(Long id) {
        return listeningQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi nghe với id = " + id));
    }
    public List<Listening_question> findByListenId(Long listenId) {
        return listeningQuestionRepository.findByListeningId(listenId);
    }

    // Tạo mới Listening_question
    public Listening_question createListeningQuestion(dtoCreateListenQuestion request) {
        Listening_question listeningQuestion = entityMapping.DTOtoCreateListeningQuestion(request);
        return listeningQuestionRepository.save(listeningQuestion);
    }

    // Cập nhật Listening_question
    public Listening_question updateListeningQuestion(Long id, dtoUpdateListenQuestion request) {
        Listening_question listeningQuestion = listeningQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi nghe với id = " + id));
        entityMapping.DTOtoUpdateListeningQuestion(listeningQuestion, request);
        return listeningQuestionRepository.save(listeningQuestion);
    }

    // Xóa Listening_question
    public void deleteListeningQuestion(Long id) {
        if (!listeningQuestionRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        listeningQuestionRepository.deleteById(id);
    }

}
