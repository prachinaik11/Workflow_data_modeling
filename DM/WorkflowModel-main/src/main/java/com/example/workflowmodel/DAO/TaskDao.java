package com.example.workflowmodel.DAO;

import com.example.workflowmodel.Entities.Task;
import com.example.workflowmodel.Entities.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDao extends JpaRepository<Task, Integer> {

    public Task findByTaskId(int taskId);

    public List<Task> findByPosition(String position);

}
