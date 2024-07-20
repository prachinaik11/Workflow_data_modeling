package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.Task;
import com.example.workflowmodel.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTaskUsingRole/{workflowId}")
    public ResponseEntity<Task> addTaskUsingRole(@RequestParam("description") String description, @PathVariable int workflowId, @RequestParam("role") String role, @RequestParam("anyAll") Boolean anyAll, @RequestParam("position") String position){
        Task task;

        try{
            task = taskService.addTaskUsingRole(description, workflowId, role, anyAll, position);
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.of(Optional.of(task));
    }

    @PostMapping("/addTaskUsingUser/{workflowId}")
    public ResponseEntity<Task> addTaskUsingUser(@RequestParam("description") String description, @PathVariable int workflowId, @RequestParam("userId") int userId, @RequestParam("anyAll") Boolean anyAll, @RequestParam("position") String position){
        Task task;

        try{
            task = taskService.addTaskUsingUser(description, workflowId, userId, anyAll, position);
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.of(Optional.of(task));
    }

    @GetMapping("/fetchTaskList/{workflowId}")
    public ResponseEntity<List<Task>> fectchAllTaskForWorkflow(@PathVariable int workflowId){
        try{
            List<Task> taskList = taskService.fetchAllTaskForWorkflow(workflowId);

            return ResponseEntity.of(Optional.of(taskList));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

}
