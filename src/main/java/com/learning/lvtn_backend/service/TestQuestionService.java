package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoTestQuestion.dtoCreateTestQuestion;
import com.learning.lvtn_backend.dto.request.dtoTestQuestion.dtoUpdateTestQuestion;
import com.learning.lvtn_backend.dto.response.dtoTestQuestion.dtoGetTestQuestion;
import com.learning.lvtn_backend.entity.TestQuestion;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.TestQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestQuestionService {
    @Autowired
    private TestQuestionRepository testQuestionRepository;
    @Autowired
    private MapperEntity questionMapping;

    public List<dtoGetTestQuestion> getAllTestQuestions() { return questionMapping.listTestQuestionToListDtoGetTestQuestion(testQuestionRepository.findAll()); }

    public dtoGetTestQuestion getTestQuestionById(int id) {
        return questionMapping.testQuestionToDtoGetTestQuestion(testQuestionRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy " + id)));
    }

    public TestQuestion createTestQuestion(dtoCreateTestQuestion question) {
           TestQuestion ques =  questionMapping.dtoCreateTestQuestionToTestQuestion(question);
            return  testQuestionRepository.save(ques); }

    public dtoGetTestQuestion updateTestQuestion(int id, dtoUpdateTestQuestion question) {
        TestQuestion existing = testQuestionRepository.findById(id).orElseThrow(()-> new RuntimeException("Không tìm thấy")) ;
        questionMapping.testQuestionUpdate(existing,question);
        TestQuestion testQuestion = testQuestionRepository.save(existing);
        return questionMapping.testQuestionToDtoGetTestQuestion(testQuestion);
    }

    public void deleteTestQuestion(int id) {
        if (!testQuestionRepository.existsById(id)) throw new RuntimeException("Test Question not found with ID = " + id);
        testQuestionRepository.deleteById(id);
    }
}
