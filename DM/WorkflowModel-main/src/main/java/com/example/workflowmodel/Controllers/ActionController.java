package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.Action;
import com.example.workflowmodel.Services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @PostMapping("/addAction/{taskId}")
    public ResponseEntity<Action> addAction(@RequestParam("name") String name, @PathVariable int taskId, @RequestParam("nextTaskId") int nextTaskId){
        try{
            Action action = actionService.addAction(name, taskId, nextTaskId);

            return ResponseEntity.of(Optional.of(action));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/viewActions/{taskId}")
    public ResponseEntity<List<Action>> viewActions(@PathVariable int taskId){
        try{
            List<Action> actionList = actionService.viewActions(taskId);

            return ResponseEntity.of(Optional.of(actionList));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }


    @PostMapping("/performAction/{userId}")
    public ResponseEntity<?> performAction(@PathVariable int userId, @RequestParam("taskInstanceId") int taskInstanceId, @RequestParam("actionId") int actionId, @RequestParam("comments") String comments){
        try{
            actionService.performAction(userId, taskInstanceId, actionId, comments);

            return ResponseEntity.status(200).build();
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

}
