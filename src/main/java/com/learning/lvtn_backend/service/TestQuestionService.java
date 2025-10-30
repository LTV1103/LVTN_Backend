package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.TestQuestion;
import com.learning.lvtn_backend.reponsitory.TestQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestQuestionService {
    @Autowired
    private TestQuestionRepository testQuestionRepository;

    public List<TestQuestion> getAllTestQuestions() { return testQuestionRepository.findAll(); }

    public TestQuestion getTestQuestionById(int id) {
        return testQuestionRepository.findById(id).orElseThrow(() -> new RuntimeException("Test Question not found with ID = " + id));
    }

    public TestQuestion createTestQuestion(TestQuestion question) { return testQuestionRepository.save(question); }

    public TestQuestion updateTestQuestion(int id, TestQuestion details) {
        TestQuestion existing = getTestQuestionById(id);
        existing.setIdTest(details.getIdTest());
        existing.setQuestionText(details.getQuestionText());
        existing.setOptionA(details.getOptionA());
        existing.setOptionB(details.getOptionB());
        existing.setOptionC(details.getOptionC());
        existing.setOptionD(details.getOptionD());
        existing.setCorrectOption(details.getCorrectOption());
        existing.setExplanation(details.getExplanation());
        return testQuestionRepository.save(existing);
    }

    public void deleteTestQuestion(int id) {
        if (!testQuestionRepository.existsById(id)) throw new RuntimeException("Test Question not found with ID = " + id);
        testQuestionRepository.deleteById(id);
    }
}
