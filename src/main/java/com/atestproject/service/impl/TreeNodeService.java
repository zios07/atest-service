package com.atestproject.service.impl;

import com.atestproject.domain.TreeNode;
import com.atestproject.exception.NotFoundException;
import com.atestproject.repository.TreeNodeRepository;
import com.atestproject.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreeNodeService implements ITreeNodeService {

    @Autowired
    private TreeNodeRepository treeNodeRepository;


    @Override
    public TreeNode addTreeNode(TreeNode treeNode) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        treeNode.setUsername(username);
        TreeNode savedTreeNode = treeNodeRepository.save(treeNode);
        if (savedTreeNode.getTestCase() != null)
            savedTreeNode.setText(savedTreeNode.getTestCase().getTitle() + " " + savedTreeNode.getTestCase().getId());
        return treeNodeRepository.save(savedTreeNode);
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
    @Transactional
    public void deleteTreeNode(Long id) throws NotFoundException {
        Optional<TreeNode> optNode = treeNodeRepository.findById(id);
        if (optNode.isPresent()) {
            TreeNode node = optNode.get();
            String idInTree = node.getId();
            treeNodeRepository.deleteByParent(idInTree);
            treeNodeRepository.deleteById(id);
        } else {
            throw new NotFoundException("NODE.NOT.FOUND", "Node not found");
        }
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
        List<TreeNode> result = new ArrayList<>();
        for (TreeNode node : nodes) {
            result.add(this.addTreeNode(node));
        }
        return result;
    }

    @Override
    public List<TreeNode> getUserTree() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.treeNodeRepository.findByUsername(username);
    }

    @Override
    public TreeNode updateNode(TreeNode node) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        node.setUsername(username);
        return treeNodeRepository.save(node);
    }
}
