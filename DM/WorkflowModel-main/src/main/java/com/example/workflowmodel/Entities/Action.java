package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionId;

    @ManyToOne
    private Task task;

    private String name;

    @ManyToOne
    private Task nextTask;

    public Action() {
    }

    public Action(int actionId, Task task, String name, Task nextTask) {
        this.actionId = actionId;
        this.task = task;
        this.name = name;
        this.nextTask = nextTask;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task getNextTask() {
        return nextTask;
    }

    public void setNextTask(Task nextTask) {
        this.nextTask = nextTask;
    }

    @Override
    public String toString() {
        return "Actions{" +
                "actionId=" + actionId +
                ", task=" + task +
                ", name='" + name + '\'' +
                ", nextTask=" + nextTask +
                '}';
    }
}
