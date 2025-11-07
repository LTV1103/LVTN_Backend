package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoTestResult.dtoCreateTestResult;
import com.learning.lvtn_backend.dto.request.dtoTestResult.dtoUpdateTestResult;
import com.learning.lvtn_backend.dto.response.dtoTestResult.dtoGetTestResult;
import com.learning.lvtn_backend.entity.TestResult;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestResultService {
    @Autowired
    private TestResultRepository testResultRepository;
    @Autowired
    private MapperEntity resultMapping;

    public List<dtoGetTestResult> getAllTestResults() { return resultMapping.listTestResultToListDtoGetTestResult(testResultRepository.findAll()); }

    public dtoGetTestResult getTestResultById(int id) {
        return resultMapping.testResultToDtoGetTestResult(testResultRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy = " + id)));
    }

    public TestResult createTestResult(dtoCreateTestResult result) {
        TestResult testResult = resultMapping.dtoCreateTestResultToTestResult(result);
        return testResultRepository.save(testResult); }

    public dtoGetTestResult updateTestResult(int id, dtoUpdateTestResult details) {
        TestResult existing = testResultRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy = " + id));
        resultMapping.testResultUpdate(existing, details);
        TestResult result = testResultRepository.save(existing);
        return resultMapping.testResultToDtoGetTestResult(result);
    }

    public void deleteTestResult(int id) {
        if (!testResultRepository.existsById(id)) throw new RuntimeException("Không tìm thấy = " + id);
        testResultRepository.deleteById(id);
    }
}
