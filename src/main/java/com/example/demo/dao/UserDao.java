package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserDao {

    User findByUsername(String username);

    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(Long id);
    public User getUserById(Long id);
    public List<User> listUsers();
}