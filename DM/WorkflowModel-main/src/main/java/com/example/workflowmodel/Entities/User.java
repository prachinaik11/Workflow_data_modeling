package com.example.workflowmodel.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    private String role;

    @OneToMany(mappedBy = "createdBy")
    @JsonIgnore
    private List<WorkflowInstance> workflowInstances;

    @OneToMany(mappedBy = "userAuthorized")
    @JsonIgnore
    private List<Task> tasksAuthorized;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<TaskInstancePerformedBy> taskInstancePerformedList;


    public User() {
    }

    public User(int userId, String name, String role, List<WorkflowInstance> workflowInstances, List<Task> tasksAuthorized, List<TaskInstancePerformedBy> taskInstancePerformedList) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.workflowInstances = workflowInstances;
        this.tasksAuthorized = tasksAuthorized;
        this.taskInstancePerformedList = taskInstancePerformedList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<WorkflowInstance> getWorkflowInstances() {
        return workflowInstances;
    }

    public void setWorkflowInstances(List<WorkflowInstance> workflowInstances) {
        this.workflowInstances = workflowInstances;
    }

    public List<Task> getTasksAuthorized() {
        return tasksAuthorized;
    }

    public void setTasksAuthorized(List<Task> tasksAuthorized) {
        this.tasksAuthorized = tasksAuthorized;
    }

    public List<TaskInstancePerformedBy> getTaskInstancePerformedList() {
        return taskInstancePerformedList;
    }

    public void setTaskInstancePerformedList(List<TaskInstancePerformedBy> taskInstancePerformedList) {
        this.taskInstancePerformedList = taskInstancePerformedList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", workflowInstances=" + workflowInstances +
                ", tasksAuthorized=" + tasksAuthorized +
                ", taskInstancePerformedList=" + taskInstancePerformedList +
                '}';
    }
}
