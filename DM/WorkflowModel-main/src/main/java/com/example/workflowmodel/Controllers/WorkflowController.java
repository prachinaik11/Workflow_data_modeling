package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.Workflow;
import com.example.workflowmodel.Services.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @PostMapping("/addWorkflow")
    public ResponseEntity<Workflow> addWorkflow(@RequestParam("name") String name){

        Workflow workflow;

        try {
            workflow = workflowService.createWorkflow(name);
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.of(Optional.of(workflow));
    }

    @GetMapping("/workflowToInitialise/{userId}")
    public ResponseEntity<List<Workflow>> workflowToInitialise(@PathVariable int userId){
        List<Workflow> workflowList;

        try{
            workflowList = workflowService.findAllWorkflowForUser(userId);

            return ResponseEntity.of(Optional.of(workflowList));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/viewAllWorkflow")
    public ResponseEntity<List<Workflow>> getAllWorkflows(){
        try{
            List<Workflow> workflowList = workflowService.getAllWorkflows();

            return ResponseEntity.of(Optional.of(workflowList));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }


}
