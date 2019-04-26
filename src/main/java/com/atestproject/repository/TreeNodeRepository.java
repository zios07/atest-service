package com.atestproject.repository;

import com.atestproject.domain.TreeNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreeNodeRepository extends JpaRepository<TreeNode, Long> {

    List<TreeNode> findByUsername(String username);
}
