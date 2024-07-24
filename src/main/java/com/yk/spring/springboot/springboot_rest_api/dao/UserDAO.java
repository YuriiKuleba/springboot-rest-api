package com.yk.spring.springboot.springboot_rest_api.dao;

import com.yk.spring.springboot.springboot_rest_api.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(int id);

}
