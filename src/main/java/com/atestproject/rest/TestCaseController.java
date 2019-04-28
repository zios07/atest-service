package com.atestproject.rest;


import com.atestproject.domain.TestCase;
import com.atestproject.domain.TreeNode;
import com.atestproject.exception.NotFoundException;
import com.atestproject.service.ITestCaseService;
import com.atestproject.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/test-cases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @Autowired
    private ITreeNodeService treeNodeService;

    @GetMapping
    public List<TestCase> getConnectedUserTestCases() {
        return testCaseService.getConnectedUserTestCases();
    }

    @PostMapping
    public TestCase createTestCase(@RequestBody TestCase testCase) {
        return testCaseService.addTestCase(testCase);
    }

    @PostMapping(value = "node")
    public TreeNode createNode(@RequestBody TreeNode node) {
        return treeNodeService.addTreeNode(node);
    }

    @PostMapping(value = "node/multiple")
    public List<TreeNode> createMultipleNodes(@RequestBody TreeNode[] nodes) {
        return treeNodeService.addMultipleNodes(nodes);
    }

    @GetMapping(value = "tree")
    public List<TreeNode> getUserTree() {
        return treeNodeService.getUserTree();
    }

    @DeleteMapping(value = "tree/node/{id}")
    public void deleteTreeNode(@PathVariable Long id) throws NotFoundException {
        treeNodeService.deleteTreeNode(id);
    }

}
