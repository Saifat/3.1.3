package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    UserService userService;



    @RequestMapping(method = RequestMethod.GET)
    public String helloAdmin(){
        return "admin";
    }
////
//    @GetMapping(value = "/admin")
//    public String listUsers(Model model){
//        List<User> userList = userService.listUsers();
//        model.addAttribute("listUsers", userList);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user1 = new User();
//        model.addAttribute("user1", user1);
//        User user = (User) authentication.getPrincipal();
//        model.addAttribute("user", user);

//        return "admin";
//    }

//
//    @RequestMapping("/remove")
//    public String removeUser(@RequestParam Long id ){
//        userService.removeUser(id);
//        return "redirect:/admin";
//    }
//
//
//
//    @PostMapping("/edit")
//    public String editUser(@RequestParam Long id, @RequestParam String firstname, @RequestParam String lastName,
//                           @RequestParam Long age, @RequestParam String username, @RequestParam String password,
//                           @RequestParam(required = false) String roleList){
//        User user1 = userService.getUserById(id);
//        user1.setFirstName(firstname);
//        user1.setLastName(lastName);
//        user1.setAge(age);
//        user1.setUsername(username);
//        user1.setPassword(password);
//        if (roleList != null) {
//            if (roleList.equals("ROLE_ADMIN")) {
//                user1.getRoles().clear();
//                user1.getRoles().add(new Role(1L, "ROLE_ADMIN"));
//            } else {
//                user1.getRoles().clear();
//                user1.getRoles().add(new Role(2L, "ROLE_USER"));
//            }
//        }
//        userService.updateUser(user1);
//
//
//        return "redirect:/admin";
//    }

}
