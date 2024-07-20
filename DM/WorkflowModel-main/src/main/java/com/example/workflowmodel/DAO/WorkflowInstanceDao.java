package com.example.workflowmodel.DAO;

import com.example.workflowmodel.Entities.User;
import com.example.workflowmodel.Entities.WorkflowInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkflowInstanceDao extends JpaRepository<WorkflowInstance, Integer> {

    public WorkflowInstance findByWorkflowInstanceId(int workflowInstanceId);

    public List<WorkflowInstance> findAllByCreatedBy(User user);
}
