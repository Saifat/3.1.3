package com.example.demo.controller;


import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class MainRestController {

    @Autowired
    UserService userService;

    @GetMapping(value = "admin/getAll")
    public List<User> getList() {
        List<User> list = userService.listUsers();
        return list;
    }

    @PostMapping("registration")
    public void registrNew(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping(value = "index/user")
    public User viewUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }

    @GetMapping("/admin/{id}")
    public User editUser(@PathVariable("id") Long id){
        User user1 = userService.getUserById(id);
        return user1;
    }



    @PutMapping(value = "admin/edit")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        if (user.getRol() != null) {
            if (user.getRol().equals("ROLE_ADMIN")) {
                user.setRoles(Collections.singleton(new Role(1L, "ROLE_ADMIN")));
            } else {
                user.setRoles(Collections.singleton(new Role(2L, "ROLE_USER")));
            }
        }
        userService.updateUser(user);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
    }


}
