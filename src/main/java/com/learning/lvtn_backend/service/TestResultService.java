package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.TestResult;
import com.learning.lvtn_backend.reponsitory.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestResultService {
    @Autowired
    private TestResultRepository testResultRepository;

    public List<TestResult> getAllTestResults() { return testResultRepository.findAll(); }

    public TestResult getTestResultById(int id) {
        return testResultRepository.findById(id).orElseThrow(() -> new RuntimeException("Test Result not found with ID = " + id));
    }

    public TestResult createTestResult(TestResult result) { return testResultRepository.save(result); }

    public TestResult updateTestResult(int id, TestResult details) {
        TestResult existing = getTestResultById(id);
        existing.setIdTest(details.getIdTest());
        existing.setIdUser(details.getIdUser());
        existing.setScore(details.getScore());
        existing.setCompletedAt(details.getCompletedAt());
        return testResultRepository.save(existing);
    }

    public void deleteTestResult(int id) {
        if (!testResultRepository.existsById(id)) throw new RuntimeException("Test Result not found with ID = " + id);
        testResultRepository.deleteById(id);
    }
}
