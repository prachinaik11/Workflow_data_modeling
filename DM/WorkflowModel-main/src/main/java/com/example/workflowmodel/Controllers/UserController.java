package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.User;
import com.example.workflowmodel.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        try{
            List<User> userList = userService.getAllUsers();

            return ResponseEntity.of(Optional.of(userList));
        }catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId){
        try {
            User singleUser = userService.getUser(userId);
            return ResponseEntity.of(Optional.of(singleUser));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestParam("name") String name, @RequestParam("role") String role){
        try{
            User user = userService.addUser(name, role);

            return ResponseEntity.of(Optional.of(user));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }
}