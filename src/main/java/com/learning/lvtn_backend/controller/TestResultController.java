package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.TestResult;
import com.learning.lvtn_backend.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/result")
public class TestResultController {

    @Autowired
    private TestResultService testResultService;

    @GetMapping
    public List<TestResult> getTestResults() {
        return testResultService.getAllTestResults();
    }

    @GetMapping("/{id}")
    public TestResult getTestResultById(@PathVariable int id) {
        return testResultService.getTestResultById(id);
    }

    @PostMapping
    public TestResult createTestResult(@RequestBody TestResult result) {
        return testResultService.createTestResult(result);
    }

    @PutMapping("/{id}")
    public TestResult updateTestResult(@PathVariable int id, @RequestBody TestResult result) {
        return testResultService.updateTestResult(id, result);
    }

    @DeleteMapping("/{id}")
    public String deleteTestResult(@PathVariable int id) {
        testResultService.deleteTestResult(id);
        return "Deleted test result with ID = " + id;
    }
}
