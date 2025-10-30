package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.Test;
import com.learning.lvtn_backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public List<Test> getTests() {
        return testService.getAllTests();
    }

    @GetMapping("/{id}")
    public Test getTestById(@PathVariable int id) {
        return testService.getTestById(id);
    }

    @PostMapping
    public Test createTest(@RequestBody Test test) {
        return testService.createTest(test);
    }

    @PutMapping("/{id}")
    public Test updateTest(@PathVariable int id, @RequestBody Test test) {
        return testService.updateTest(id, test);
    }

    @DeleteMapping("/{id}")
    public String deleteTest(@PathVariable int id) {
        testService.deleteTest(id);
        return "Deleted test with ID = " + id;
    }
}
