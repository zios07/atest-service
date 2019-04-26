package com.atestproject.service.impl;

import com.atestproject.domain.TestCase;
import com.atestproject.domain.TreeNode;
import com.atestproject.exception.NotFoundException;
import com.atestproject.repository.TreeNodeRepository;
import com.atestproject.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TreeNodeService implements ITreeNodeService {

    @Autowired
    private TreeNodeRepository treeNodeRepository;


    @Override
    public TreeNode addTreeNode(TreeNode treeNode) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        treeNode.setUsername(username);
        return treeNodeRepository.save(treeNode);
    }

    @Override
    public TreeNode findTreeNode(long id) throws NotFoundException {
        return null;
    }

    @Override
    public List<TreeNode> findAllTreeNodes() {
        return null;
    }

    @Override
    public void deleteTreeNode(long id) throws NotFoundException {

    }

    @Override
    public List<TreeNode> searchTreeNodes(TreeNode treeNode) throws NotFoundException {
        return null;
    }

    @Override
    public TreeNode findTreeNodeByUsername(String username) throws NotFoundException {
        return null;
    }

    @Override
    public List<TreeNode> getConnectedUserTreeNodes() {
        return null;
    }

    @Override
    public List<TreeNode> addMultipleNodes(TreeNode[] nodes) {
        for (TreeNode node : nodes) {
            this.addTreeNode(node);
        }
        return Arrays.asList(nodes);
    }

    @Override
    public List<TreeNode> getUserTree() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.treeNodeRepository.findByUsername(username);
    }
}
