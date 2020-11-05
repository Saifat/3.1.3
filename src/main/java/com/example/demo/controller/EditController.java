package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EditController {

    @Autowired
    UserService userService;

    @GetMapping(value = "indexUser")
    public String viewUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "indexUser";
    }
    @GetMapping(value = "/admin")
    public String listUsers(Model model){
        List<User> userList = userService.listUsers();
        model.addAttribute("listUsers", userList);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user1 = new User();
        model.addAttribute("user1", user1);
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "admin";
    }
    @GetMapping(value = "index")
    public User viewUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }

}
