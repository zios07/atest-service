package com.atestproject.service;

import com.atestproject.domain.TreeNode;
import com.atestproject.exception.NotFoundException;

import java.util.List;

public interface ITreeNodeService {

	TreeNode addTreeNode(TreeNode treeNode);

	TreeNode findTreeNode(long id) throws NotFoundException;

	List<TreeNode> findAllTreeNodes();

	void deleteTreeNode(long id) throws NotFoundException;

	List<TreeNode> searchTreeNodes(TreeNode treeNode) throws NotFoundException;
	
	TreeNode findTreeNodeByUsername(String username) throws NotFoundException;

    List<TreeNode> getConnectedUserTreeNodes();

    List<TreeNode> addMultipleNodes(TreeNode[] nodes);

	List<TreeNode> getUserTree();
}
