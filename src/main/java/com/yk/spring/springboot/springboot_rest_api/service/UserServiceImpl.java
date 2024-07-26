package com.yk.spring.springboot.springboot_rest_api.service;

import com.yk.spring.springboot.springboot_rest_api.configuration.MultiTenantManager;
import com.yk.spring.springboot.springboot_rest_api.dao.UserRepository;
import com.yk.spring.springboot.springboot_rest_api.entity.User;
import com.yk.spring.springboot.springboot_rest_api.model.DataSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MultiTenantManager tenantManager;

//    @Autowired
//    private UserDAO userDAO;

    @Autowired
    private DataSourceService sourceService;

    private List<DataSourceProperties> dataSourceProperties;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        dataSourceProperties = sourceService.readMyObjects();
        for (int i = 0; i < dataSourceProperties.size(); i++) {
            DataSourceProperties dataSource = dataSourceProperties.get(i);
            try {
                tenantManager.addTenant(String.valueOf(i), dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword(), dataSource.getDriverClassName());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        List<User> users = new ArrayList<>();

        List<String> tenantNames = tenantManager.getTenantNames();

        for (String tenantName : tenantNames) {
            tenantManager.setCurrentTenant(tenantName);
            List<User> allUsers = userRepository.findAll();
            users.addAll(allUsers);
        }
        return users;
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

}
