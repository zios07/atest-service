package com.atestproject.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class TreeNode {

    @Id @GeneratedValue
    private Long technicalID;

    private String id;

    private Long seq;

    private String text;

    private String type;

    private String parent;

    @OneToOne(cascade = CascadeType.ALL)
    private TestCase testCase;

    private String username;

    public TreeNode() {
    }

    public Long getTechnicalID() {
        return technicalID;
    }

    public void setTechnicalID(Long technicalID) {
        this.technicalID = technicalID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }
}
