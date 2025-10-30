package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.Test;
import com.learning.lvtn_backend.reponsitory.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public List<Test> getAllTests() { return testRepository.findAll(); }

    public Test getTestById(int id) {
        return testRepository.findById(id).orElseThrow(() -> new RuntimeException("Test not found with ID = " + id));
    }

    public Test createTest(Test test) { return testRepository.save(test); }

    public Test updateTest(int id, Test details) {
        Test existing = getTestById(id);
        existing.setIdCourse(details.getIdCourse());
        existing.setTestTitle(details.getTestTitle());
        existing.setDescription(details.getDescription());
        existing.setTestType(details.getTestType());
        existing.setTotalQuestions(details.getTotalQuestions());
        existing.setTimeLimit(details.getTimeLimit());
        existing.setCreatedAt(details.getCreatedAt());
        return testRepository.save(existing);
    }

    public void deleteTest(int id) {
        if (!testRepository.existsById(id)) throw new RuntimeException("Test not found with ID = " + id);
        testRepository.deleteById(id);
    }
}
