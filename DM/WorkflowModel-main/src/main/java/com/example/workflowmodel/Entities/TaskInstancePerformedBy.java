package com.example.workflowmodel.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class TaskInstancePerformedBy {

    @EmbeddedId
    private TaskInstancePerformedId id = new TaskInstancePerformedId();

    @ManyToOne()
    @MapsId("taskInstanceId")
    @JsonIgnore
    private TaskInstance taskInstance;

    @ManyToOne
    @MapsId("userId")
    @JsonIgnore
    private User user;

    private String status;

    private String comments;

    public TaskInstancePerformedBy() {
    }

    public TaskInstancePerformedBy(TaskInstancePerformedId id, TaskInstance taskInstance, User user, String status, String comments) {
        this.id = id;
        this.taskInstance = taskInstance;
        this.user = user;
        this.status = status;
        this.comments = comments;
    }

    public TaskInstancePerformedId getId() {
        return id;
    }

    public void setId(TaskInstancePerformedId id) {
        this.id = id;
    }

    public TaskInstance getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstance taskInstance) {
        this.taskInstance = taskInstance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
