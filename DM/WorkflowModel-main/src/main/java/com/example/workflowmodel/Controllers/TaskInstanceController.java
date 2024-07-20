package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.TaskInstance;
import com.example.workflowmodel.Services.TaskInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/taskInstance")
public class TaskInstanceController {

    @Autowired
    private TaskInstanceService taskInstanceService;

    @GetMapping("/fetchTaskInstances/{userId}")
    public ResponseEntity<List<TaskInstance>> getTaskInstanceList(@PathVariable int userId){
        try{
            List<TaskInstance> taskInstanceList = taskInstanceService.fetchTaskInstanceForUser(userId);

            return ResponseEntity.of(Optional.of(taskInstanceList));
        }catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/taskInstances/{workflowInstanceId}")
    public ResponseEntity<List<TaskInstance>> taskInstancesByWorkflow(@PathVariable int workflowInstanceId){
        try{
            List<TaskInstance> taskInstanceList = taskInstanceService.fetchTaskInstanceForWorkflowInstance(workflowInstanceId);

            return ResponseEntity.of(Optional.of(taskInstanceList));
        }catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }

}
