package com.atestproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity
public class TestCase implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String type;
    private String category;
    private String priority;
    private String comoplexity;
    private String componentName;
    private String componentOwner;
    private String executionType;
    private String requirementReference;
    private String requirementOwner;
    private String requirementPath;
    private String preConditions;
    private String steps;
    private String verifications;

    public TestCase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getComoplexity() {
        return comoplexity;
    }

    public void setComoplexity(String comoplexity) {
        this.comoplexity = comoplexity;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentOwner() {
        return componentOwner;
    }

    public void setComponentOwner(String componentOwner) {
        this.componentOwner = componentOwner;
    }

    public String getExecutionType() {
        return executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public String getRequirementReference() {
        return requirementReference;
    }

    public void setRequirementReference(String requirementReference) {
        this.requirementReference = requirementReference;
    }

    public String getRequirementOwner() {
        return requirementOwner;
    }

    public void setRequirementOwner(String requirementOwner) {
        this.requirementOwner = requirementOwner;
    }

    public String getRequirementPath() {
        return requirementPath;
    }

    public void setRequirementPath(String requirementPath) {
        this.requirementPath = requirementPath;
    }

    public String getPreConditions() {
        return preConditions;
    }

    public void setPreConditions(String preConditions) {
        this.preConditions = preConditions;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getVerifications() {
        return verifications;
    }

    public void setVerifications(String verifications) {
        this.verifications = verifications;
    }

}
