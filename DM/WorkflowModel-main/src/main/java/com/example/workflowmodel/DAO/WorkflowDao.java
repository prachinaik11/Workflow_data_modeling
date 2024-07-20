package com.example.workflowmodel.DAO;

import com.example.workflowmodel.Entities.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowDao extends JpaRepository<Workflow, Integer> {

    public Workflow findByWorkflowId(int workflowId);

}
