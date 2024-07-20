package com.example.workflowmodel.DAO;

import com.example.workflowmodel.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    public List<User> findByRole(String role);

    public User findByUserId(int userId);


}
