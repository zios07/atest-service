package com.atestproject.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class TreeNode {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private String type;

    @OneToOne
    private TreeNode parent;

    @OneToMany
    private List<TreeNode> children;

    @OneToOne(cascade = CascadeType.ALL)
    private TestCase testCase;

    public TreeNode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }
}
