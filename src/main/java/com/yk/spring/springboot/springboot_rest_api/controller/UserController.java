package com.yk.spring.springboot.springboot_rest_api.controller;

import com.yk.spring.springboot.springboot_rest_api.entity.User;
import com.yk.spring.springboot.springboot_rest_api.exception.NoSuchUserException;
import com.yk.spring.springboot.springboot_rest_api.exception.UserIncorrectData;
import com.yk.spring.springboot.springboot_rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {

        User user = userService.getUserById(id);

        if (user == null) {
            throw new NoSuchUserException("There is no employee with id = " + id + " in Database");
        }
        return user;
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handlerException(NoSuchUserException noSuchUserException) {
        UserIncorrectData userIncorrectData = new UserIncorrectData();
        userIncorrectData.setInfo(noSuchUserException.getMessage());

        return new ResponseEntity<>(userIncorrectData, HttpStatus.NOT_FOUND);
    }

}
