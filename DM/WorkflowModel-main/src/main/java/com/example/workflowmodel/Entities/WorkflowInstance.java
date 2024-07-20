package com.example.workflowmodel.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class WorkflowInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workflowInstanceId;

    private String status;

    private String description;

    private String attachments;

    @ManyToOne
    private Workflow workflow;

    @ManyToOne
    private User createdBy;

    @OneToMany(mappedBy = "workflowInstance")
    @JsonIgnore
    private List<TaskInstance> taskInstanceList;

    public WorkflowInstance() {
    }

    public WorkflowInstance(int workflowInstanceId, String status, String description, String attachments, Workflow workflow, User createdBy, List<TaskInstance> taskInstanceList) {
        this.workflowInstanceId = workflowInstanceId;
        this.status = status;
        this.description = description;
        this.attachments = attachments;
        this.workflow = workflow;
        this.createdBy = createdBy;
        this.taskInstanceList = taskInstanceList;
    }

    public int getWorkflowInstanceId() {
        return workflowInstanceId;
    }

    public void setWorkflowInstanceId(int workflowInstanceId) {
        this.workflowInstanceId = workflowInstanceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<TaskInstance> getTaskInstanceList() {
        return taskInstanceList;
    }

    public void setTaskInstanceList(List<TaskInstance> taskInstanceList) {
        this.taskInstanceList = taskInstanceList;
    }

    @Override
    public String toString() {
        return "WorkflowInstance{" +
                "workflowInstanceId=" + workflowInstanceId +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", attachments='" + attachments + '\'' +
                ", workflow=" + workflow +
                ", createdBy=" + createdBy +
                ", taskInstanceList=" + taskInstanceList +
                '}';
    }
}
