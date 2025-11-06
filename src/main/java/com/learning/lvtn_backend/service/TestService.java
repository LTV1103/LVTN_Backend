package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoTest.dtoCreateTest;
import com.learning.lvtn_backend.dto.request.dtoTest.dtoUpdateTest;
import com.learning.lvtn_backend.dto.response.dtoGetTest;
import com.learning.lvtn_backend.entity.Test;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private MapperEntity TestMapping;

    public List<dtoGetTest> getAllTests() {
        return TestMapping.dtoToGetTestList(testRepository.findAll());
    }

    public dtoGetTest getTestById(int id) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài kiểm tra có ID = " + id));
        return TestMapping.dtoToGetTest(test);
    }

    public dtoGetTest createTest(dtoCreateTest request) {
        Test test = TestMapping.testToTest(request);
        return TestMapping.dtoToGetTest(testRepository.save(test));
    }

    public dtoGetTest updateTest(int id, dtoUpdateTest request) {
        Test existing = testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài kiểm tra có ID = " + id));
        TestMapping.testUpdate(existing, request);
        return TestMapping.dtoToGetTest(testRepository.save(existing));
    }

    public void deleteTest(int id) {
        if (!testRepository.existsById(id))
            throw new RuntimeException("Không tìm thấy bài kiểm tra có ID = " + id);
        testRepository.deleteById(id);
    }
}
