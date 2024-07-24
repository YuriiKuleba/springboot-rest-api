package com.yk.spring.springboot.springboot_rest_api.service;


import com.yk.spring.springboot.springboot_rest_api.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

}
