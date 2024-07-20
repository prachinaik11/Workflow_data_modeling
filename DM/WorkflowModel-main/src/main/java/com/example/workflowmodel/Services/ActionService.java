package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.*;
import com.example.workflowmodel.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionService {

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskInstanceDao taskInstanceDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TaskInstancePerformedByDao taskInstancePerformedByDao;

    @Autowired
    private WorkflowInstanceDao workflowInstanceDao;

    public Action addAction(String name, int taskId, int nextTaskId){

        try {
            Action action = new Action();
            Task task = taskDao.findByTaskId(taskId);

            Task nextTask = taskDao.findByTaskId(nextTaskId);


            action.setName(name);
            action.setTask(task);
            action.setNextTask(nextTask);

            action = actionDao.save(action);

            return action;
        }catch (Exception e){
            System.out.println("Adding action error");
            throw new RuntimeException();
        }
    }


    public List<Action> viewActions(int taskId) {
        try {
            Task task = taskDao.findByTaskId(taskId);

            List<Action> actionList = actionDao.findAllByTask(task);

            return actionList;
        }catch (Exception e){
            System.out.println("Viewing action error");
            throw new RuntimeException();
        }
    }

    public void performAction(int userId, int taskInstanceId, int actionId, String comments){
        try{
            TaskInstance taskInstance = taskInstanceDao.findByTaskInstanceId(taskInstanceId);

            WorkflowInstance workflowInstanceHere = taskInstance.getWorkflowInstance();

            workflowInstanceHere.setStatus("InProgress");

            workflowInstanceDao.save(workflowInstanceHere);

            User user = userDao.findByUserId(userId);

            TaskInstancePerformedBy taskInstancePerformedBy = taskInstancePerformedByDao.findByTaskInstanceAndUser(taskInstance, user);

            taskInstancePerformedBy.setStatus("Completed");
            taskInstancePerformedBy.setComments(comments);

            taskInstancePerformedByDao.save(taskInstancePerformedBy);

            taskInstance.setStatus("InProgress");

            if(!taskInstance.getTask().getAnyAll()){
                List<TaskInstancePerformedBy> pending = taskInstancePerformedByDao.findByTaskInstanceAndStatus(taskInstance, "Pending");

                pending.forEach(t -> {
                    t.setStatus("Done By Others");
                    t.setComments("NULL");

                    taskInstancePerformedByDao.save(t);
                });
            }

            List<TaskInstancePerformedBy> taskInstancePerformedByList = taskInstancePerformedByDao.findByTaskInstanceAndStatus(taskInstance, "Pending");

            if(taskInstancePerformedByList==null || taskInstancePerformedByList.size()==0){

                taskInstance.setStatus("Completed");

                taskInstanceDao.save(taskInstance);

                Action action = actionDao.findByActionId(actionId);

                Task newTask = action.getNextTask();

                if(newTask.getActionsList()==null || newTask.getActionsList().size()==0){
                    WorkflowInstance workflowInstance = taskInstance.getWorkflowInstance();

                    workflowInstance.setStatus("Completed");

                    taskInstanceDao.save(taskInstance);

                    TaskInstance newTaskInstance = new TaskInstance();

                    newTaskInstance.setStatus("Completed");
                    newTaskInstance.setWorkflowInstance(workflowInstance);
                    newTaskInstance.setTask(newTask);


                    taskInstanceDao.save(newTaskInstance);

                    workflowInstanceDao.save(workflowInstance);

                    return;
                }


                TaskInstance newTaskInstance = new TaskInstance();

                newTaskInstance.setStatus("Pending");
                newTaskInstance.setWorkflowInstance(taskInstance.getWorkflowInstance());
                newTaskInstance.setTask(newTask);

                List<User> performedByUserList = new ArrayList<>();

                if(newTask.getRole()!=null)
                    performedByUserList.addAll(userDao.findByRole(newTask.getRole()));
                else
                    performedByUserList.add(newTask.getUserAuthorized());


                TaskInstance finalTaskInstance = newTaskInstance;
                newTaskInstance.setTaskInstancePerformedByList(performedByUserList.stream().map(user1 -> {
                    TaskInstancePerformedBy taskInstancePerformedBy1 = new TaskInstancePerformedBy();
                    taskInstancePerformedBy1.setUser(user1);
                    taskInstancePerformedBy1.setTaskInstance(finalTaskInstance);
                    taskInstancePerformedBy1.setStatus("Pending");
                    return taskInstancePerformedBy1;
                }).toList());

                taskInstanceDao.save(newTaskInstance);
            }

            taskInstanceDao.save(taskInstance);

        }catch (Exception e){
            System.out.println("Action performed created error");
            throw new RuntimeException();
        }
    }
}
