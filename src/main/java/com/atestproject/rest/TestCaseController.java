package com.atestproject.rest;


import com.atestproject.domain.TestCase;
import com.atestproject.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/test-cases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

//    @GetMapping
//    public List<TestCase> findAll() {
//        return testCaseService.findAllTestCases();
//    }

    @GetMapping
    public List<TestCase> getConnectedUserTestCases() {
        return testCaseService.getConnectedUserTestCases();
    }

    @PostMapping
    public TestCase createTestCase(@RequestBody TestCase testCase) {
        return testCaseService.addTestCase(testCase);
    }

}
