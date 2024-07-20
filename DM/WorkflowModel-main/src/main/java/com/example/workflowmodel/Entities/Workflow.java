package com.example.workflowmodel.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workflowId;
    private String name;
    @OneToMany(mappedBy = "workflow")
    @JsonIgnore
    private List<Task> tasksList;

    @OneToMany(mappedBy = "workflow")
    @JsonIgnore
    private List<WorkflowInstance> workflowInstanceList;


    public Workflow() {
    }

    public Workflow(int workflowId, String name, List<Task> tasksList, List<WorkflowInstance> workflowInstanceList) {
        this.workflowId = workflowId;
        this.name = name;
        this.tasksList = tasksList;
        this.workflowInstanceList = workflowInstanceList;
    }


    public int getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(int workflowId) {
        this.workflowId = workflowId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Task> taskList) {
        this.tasksList = taskList;
    }

    public List<WorkflowInstance> getWorkflowInstanceList() {
        return workflowInstanceList;
    }

    public void setWorkflowInstanceList(List<WorkflowInstance> workflowInstanceList) {
        this.workflowInstanceList = workflowInstanceList;
    }

    @Override
    public String toString() {
        return "Workflow{" +
                "workflowId=" + workflowId +
                ", name='" + name + '\'' +
                ", taskList=" + tasksList +
                ", workflowInstanceList=" + workflowInstanceList +
                '}';
    }
}
