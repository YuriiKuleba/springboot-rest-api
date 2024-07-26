package com.yk.spring.springboot.springboot_rest_api.configuration;

import com.yk.spring.springboot.springboot_rest_api.dao.UserDAO;
import com.yk.spring.springboot.springboot_rest_api.dao.UserDAOImpl;
import com.yk.spring.springboot.springboot_rest_api.service.DataSourceService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "data-source")
public class EntityManagerConfig {

    public List<UserDAO> userDAOList() {
        return null;
    }
}
