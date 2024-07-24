package com.yk.spring.springboot.springboot_rest_api.service;

import com.yk.spring.springboot.springboot_rest_api.dao.UserDAO;
import com.yk.spring.springboot.springboot_rest_api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {return userDAO.getUserById(id); }

}
