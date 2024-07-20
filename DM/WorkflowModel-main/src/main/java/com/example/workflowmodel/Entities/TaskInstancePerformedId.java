package com.example.workflowmodel.Entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TaskInstancePerformedId implements Serializable {
    private int taskInstanceId;

    private int userId;

    public TaskInstancePerformedId() {
    }

    public TaskInstancePerformedId(int taskInstanceId, int userId) {
        this.taskInstanceId = taskInstanceId;
        this.userId = userId;
    }

    public int getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(int taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TaskInstancePerformedId{" +
                "taskInstanceId=" + taskInstanceId +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskInstancePerformedId that = (TaskInstancePerformedId) o;
        return taskInstanceId == that.taskInstanceId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskInstanceId, userId);
    }
}
