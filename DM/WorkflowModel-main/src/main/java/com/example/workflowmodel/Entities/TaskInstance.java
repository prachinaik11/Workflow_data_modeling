package com.example.workflowmodel.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TaskInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskInstanceId;


    private String status;

    @OneToMany(mappedBy = "taskInstance", cascade = CascadeType.ALL)
    private List<TaskInstancePerformedBy> taskInstancePerformedByList;

    @ManyToOne
    private WorkflowInstance workflowInstance;

    @ManyToOne
    private Task task;


    public TaskInstance() {
    }

    public TaskInstance(int taskInstanceId, String status, List<TaskInstancePerformedBy> taskInstancePerformedByList, WorkflowInstance workflowInstance, Task task) {
        this.taskInstanceId = taskInstanceId;
        this.status = status;
        this.taskInstancePerformedByList = taskInstancePerformedByList;
        this.workflowInstance = workflowInstance;
        this.task = task;
    }

    public int getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(int taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TaskInstancePerformedBy> getTaskInstancePerformedByList() {
        return taskInstancePerformedByList;
    }

    public void setTaskInstancePerformedByList(List<TaskInstancePerformedBy> taskInstancePerformedByList) {
        this.taskInstancePerformedByList = taskInstancePerformedByList;
    }

    public WorkflowInstance getWorkflowInstance() {
        return workflowInstance;
    }

    public void setWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstance = workflowInstance;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskInstance{" +
                "taskInstanceId=" + taskInstanceId +
                ", status='" + status + '\'' +
                ", taskInstancePerformedByList=" + taskInstancePerformedByList +
                ", workflowInstance=" + workflowInstance +
                ", task=" + task +
                '}';
    }
}
