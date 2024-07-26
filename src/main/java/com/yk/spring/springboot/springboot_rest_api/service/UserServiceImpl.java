package com.yk.spring.springboot.springboot_rest_api.service;

import com.yk.spring.springboot.springboot_rest_api.ApplicationContextProvider;
import com.yk.spring.springboot.springboot_rest_api.configuration.DataSourceConfig;
import com.yk.spring.springboot.springboot_rest_api.dao.UserDAO;
import com.yk.spring.springboot.springboot_rest_api.entity.User;
import com.yk.spring.springboot.springboot_rest_api.listeners.RetrieveDataListener;
import com.yk.spring.springboot.springboot_rest_api.model.DataSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

//    @Autowired
    private DataSourceConfig dataSourceConfig;

//    @Autowired
    private DataSourceService dataSourceService;

    private List<RetrieveDataListener> listeners = new ArrayList<>();

    private List<DataSourceProperties> dataSourceProperties;

    public UserServiceImpl() {
        dataSourceConfig = ApplicationContextProvider.getApplicationContext().getBean(DataSourceConfig.class);
        if (dataSourceConfig != null) {
            addListener(dataSourceConfig);
        }

        dataSourceService = ApplicationContextProvider.getApplicationContext().getBean(DataSourceService.class);
        dataSourceProperties = dataSourceService.readMyObjects();
        LOGGER.info("$$$$$ " + dataSourceProperties);
    }

    public void addListener(RetrieveDataListener listener) {
        listeners.add(listener);
    }

    public void removeListener(RetrieveDataListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(DataSourceProperties properties) {
        for (RetrieveDataListener listener : listeners) {
            listener.onRetrieveData(properties);

        }
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        if (!dataSourceProperties.isEmpty()) {
            for (DataSourceProperties properties : dataSourceProperties) {
                notifyListeners(properties);
                users.addAll(userDAO.getAllUsers());
            }
        }

        return users;
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

}
