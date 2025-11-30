package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.reading_question.dtoCreateReadQuestion;
import com.learning.be_english_course.DTO.request.reading_question.dtoUpdateReadQuestion;
import com.learning.be_english_course.Entity.Reading_question;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.ReadingQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingQuestionService {

    @Autowired
    private ReadingQuestionRepository readingQuestionRepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Reading_question
    public List<Reading_question> findAll() {
        return readingQuestionRepository.findAll();
    }

    // Tìm theo id
    public Reading_question findById(Long id) {
        return readingQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi đọc với id = " + id));
    }

    // Tạo mới Reading_question
    public Reading_question createReadingQuestion(dtoCreateReadQuestion request) {
        Reading_question readingQuestion = entityMapping.DTOtoCreateReadingQuestion(request);
        return readingQuestionRepository.save(readingQuestion);
    }

    // Cập nhật Reading_question
    public Reading_question updateReadingQuestion(Long id, dtoUpdateReadQuestion request) {
        Reading_question readingQuestion = readingQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi đọc với id = " + id));
        entityMapping.DTOtoUpdateReadingQuestion(readingQuestion, request);
        return readingQuestionRepository.save(readingQuestion);
    }

    // Xóa Reading_question
    public void deleteReadingQuestion(Long id) {
        if (!readingQuestionRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        readingQuestionRepository.deleteById(id);
    }

}
