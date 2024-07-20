package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.TaskDao;
import com.example.workflowmodel.DAO.UserDao;
import com.example.workflowmodel.DAO.WorkflowDao;
import com.example.workflowmodel.Entities.Task;
import com.example.workflowmodel.Entities.User;
import com.example.workflowmodel.Entities.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private WorkflowDao workflowDao;

    @Autowired
    private UserDao userDao;


    public Task addTaskUsingRole(String description, int workflowId, String role, Boolean anyAll, String position){

        try{
            Workflow workflow = workflowDao.findByWorkflowId(workflowId);

            if(workflow==null){
                System.out.printf("Workflow Not found");
                return null;
            }

            Task task = new Task();

            task.setDescription(description);
            task.setRole(role);
            task.setWorkflow(workflow);
            task.setAnyAll(anyAll);
            task.setPosition(position);

            task = taskDao.save(task);

            return task;
        }catch (Exception e){
            System.out.println("Task adding using role error");
            throw new RuntimeException();
        }
    }

    public Task addTaskUsingUser(String description, int workflowId, int userId, Boolean anyAll, String position){

        try{
            Workflow workflow = workflowDao.findByWorkflowId(workflowId);
            User user = userDao.findByUserId(userId);

            if(user==null){
                System.out.println("User not available");
                throw new RuntimeException();
            }

            Task task = new Task();

            task.setDescription(description);
            task.setWorkflow(workflow);
            task.setUserAuthorized(user);
            task.setAnyAll(anyAll);
            task.setPosition(position);

            task = taskDao.save(task);

            return task;
        }catch (Exception e){
            System.out.println("adding task using user error");
            throw new RuntimeException();
        }
    }


//    public Task getSingleTask(int taskId){
//        Task task;
//
//        try{
//            task = taskDao.findByTaskId(taskId);
//
//            return task;
//        }catch (Exception e){
//            System.out.println("get single task error");
//            throw new RuntimeException();
//        }
//    }


    public List<Task> fetchAllTaskForWorkflow(int workflowId){

        try{
            Workflow workflow = workflowDao.findByWorkflowId(workflowId);

            List<Task> taskList = workflow.getTasksList();

            return taskList;
        }catch (Exception e){
            System.out.println("fetching all tasks for workflow error");
            throw new RuntimeException();
        }
    }


}
