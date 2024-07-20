package com.example.workflowmodel.DAO;

import com.example.workflowmodel.Entities.Action;
import com.example.workflowmodel.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionDao extends JpaRepository<Action, Integer> {

    List<Action> findAllByTask(Task task);

    Action findByActionId(int actionId);

}
