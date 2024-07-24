package com.yk.spring.springboot.springboot_rest_api.controller;


import com.yk.spring.springboot.springboot_rest_api.entity.User;
import com.yk.spring.springboot.springboot_rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showAllEmployees() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getEmployeeById(@PathVariable int id) {

        User user = userService.getUserById(id);

        return user;
    }

}
