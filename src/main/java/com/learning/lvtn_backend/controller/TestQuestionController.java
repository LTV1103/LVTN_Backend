package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.TestQuestion;
import com.learning.lvtn_backend.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/question")
public class TestQuestionController {

    @Autowired
    private TestQuestionService testQuestionService;

    @GetMapping
    public List<TestQuestion> getTestQuestions() {
        return testQuestionService.getAllTestQuestions();
    }

    @GetMapping("/{id}")
    public TestQuestion getTestQuestionById(@PathVariable int id) {
        return testQuestionService.getTestQuestionById(id);
    }

    @PostMapping
    public TestQuestion createTestQuestion(@RequestBody TestQuestion question) {
        return testQuestionService.createTestQuestion(question);
    }

    @PutMapping("/{id}")
    public TestQuestion updateTestQuestion(@PathVariable int id, @RequestBody TestQuestion question) {
        return testQuestionService.updateTestQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    public String deleteTestQuestion(@PathVariable int id) {
        testQuestionService.deleteTestQuestion(id);
        return "Deleted test question with ID = " + id;
    }
}
