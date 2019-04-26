package com.atestproject.service;

import com.atestproject.domain.TestCase;
import com.atestproject.domain.TreeNode;
import com.atestproject.exception.NotFoundException;

import java.util.List;

public interface ITestCaseService {

	TestCase addTestCase(TestCase testCase);

	TestCase findTestCase(long id) throws NotFoundException;

	List<TestCase> findAllTestCases();

	void deleteTestCase(long id) throws NotFoundException;

	List<TestCase> searchTestCases(TestCase testCase) throws NotFoundException;
	
	TestCase findTestCaseByUsername(String username) throws NotFoundException;

    List<TestCase> getConnectedUserTestCases();

}
