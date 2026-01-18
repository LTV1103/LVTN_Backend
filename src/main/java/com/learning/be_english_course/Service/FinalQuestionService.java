package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.final_question.dtoCreateQuestion;
import com.learning.be_english_course.DTO.request.final_question.dtoUpdateQuestion;
import com.learning.be_english_course.DTO.respone.test.dtoScore;
import com.learning.be_english_course.Entity.Final_question;
import com.learning.be_english_course.Entity.Final_result;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.FinalQuestionRepository;
import com.learning.be_english_course.Repository.FinalResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FinalQuestionService {
    @Autowired
    private FinalQuestionRepository finalQuestionRepository;
    @Autowired
    private EntityMapping entityMapping;
    @Autowired
    private FinalResultRepository finalResultRepository;

    // Lấy tất cả Final_question
    public List<Final_question> findAll() {
        return finalQuestionRepository.findAll();
    }
    // Tìm theo id
    public Final_question findById(Long id) {
        return finalQuestionRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi với id = " + id));
    }
    //ds theo bai test
    public List<Final_question> findByFinalTestId(Long finalTestId) {
        return finalQuestionRepository.findByFinalTestId(finalTestId);
    }
    // lay ds kq
    public String getResultQuestion(Long testId) {
        List<String> results = finalQuestionRepository.findAllCorrectOptions(testId);
        return String.join("", results);
    }
    // tinh diem
    public dtoScore scoreTest(String answer , long testID , long userID) {
        int correct = 0;
        int wrong = 0;
        String correctAnswer = getResultQuestion(testID);
        int length = Math.min(answer.length(), correctAnswer.length());
        for (int i = 0; i < length; i++) {
            if (answer.charAt(i) == correctAnswer.charAt(i)) {
                correct++;
            } else {
                wrong++;
            }
        }
        wrong += Math.abs(answer.length() - correctAnswer.length());
        int score = (int)((double) correct / correctAnswer.length() * 100);
        Final_result finalResult = new Final_result();
        finalResult.setScore(BigDecimal.valueOf(score));
        finalResult.setFinalTestId(testID);
        finalResult.setCompletedAt(LocalDateTime.now());
        finalResult.setUserId(userID);
        finalResultRepository.save(finalResult);
        dtoScore dto = new dtoScore();
        dto.setCorrect(correct);
        dto.setWrong(wrong);
        dto.setScore(score);

        return dto;
    }

    // Tạo mới ds cau hoi
    public List<Final_question> createFinalQuestions(List<dtoCreateQuestion> requests) {
        List<Final_question> finalQuestions = requests.stream()
                .map(req -> {
                    Final_question q = new Final_question();
                    q.setFinalTestId(req.getFinalTestId());
                    q.setQuestionText(req.getQuestionText());
                    q.setOptionA(req.getOptionA());
                    q.setOptionB(req.getOptionB());
                    q.setOptionC(req.getOptionC());
                    q.setOptionD(req.getOptionD());
                    q.setCorrectOption(req.getCorrectOption());
                    q.setExplanation(req.getExplanation());
                    return q;
                })
                .toList();
        return finalQuestionRepository.saveAll(finalQuestions);
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
