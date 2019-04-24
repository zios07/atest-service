package com.atestproject.repository;

import com.atestproject.domain.TestCase;
import com.atestproject.domain.TreeNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeNodeRepository extends JpaRepository<TreeNode, Long> {

}
