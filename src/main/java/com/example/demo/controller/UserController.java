package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String hello(){
        return "login";
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registr(Model model){
        User user = new User();
        model.addAttribute(user);
        return "registration";
    }
    @PostMapping("registration")
    public String registrNew(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/admin";
    }


    @GetMapping(value = "index")
    public String viewUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }




}
