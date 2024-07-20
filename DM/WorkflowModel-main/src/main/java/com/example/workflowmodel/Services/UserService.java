package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.UserDao;
import com.example.workflowmodel.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){

        try {
             List<User> userList = userDao.findAll();

             return userList;
        }catch (Exception e){
            System.out.println("fetching users list error");
            throw new RuntimeException();
        }
    }
    public User getUser(int userId){
        try {
            User singleUser = userDao.findByUserId(userId);
            return singleUser;
        }catch (Exception e){
            System.out.println("User not found");
            throw new RuntimeException();
        }
    }


    public User addUser(String name, String role) {
        try {
            User newUser = new User();

            newUser.setName(name);
            newUser.setRole(role);

            return newUser;
        }catch (Exception e){
            System.out.println("User create error");
            throw new RuntimeException();
        }
    }
}
