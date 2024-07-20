package com.example.workflowmodel.DAO;


import com.example.workflowmodel.Entities.TaskInstance;
import com.example.workflowmodel.Entities.TaskInstancePerformedBy;
import com.example.workflowmodel.Entities.TaskInstancePerformedId;
import com.example.workflowmodel.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskInstancePerformedByDao extends JpaRepository<TaskInstancePerformedBy, TaskInstancePerformedId> {

    List<TaskInstancePerformedBy> findByStatusAndUser(String status, User user);

    List<TaskInstancePerformedBy> findByTaskInstanceAndStatus(TaskInstance taskInstance, String status);

    TaskInstancePerformedBy findByTaskInstanceAndUser(TaskInstance taskInstance, User user);

}
