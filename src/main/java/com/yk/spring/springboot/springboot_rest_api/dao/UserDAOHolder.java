package com.yk.spring.springboot.springboot_rest_api.dao;

import java.util.List;

public class UserDAOHolder {

    private List<UserDAO> userDAOList;

    public UserDAOHolder(List<UserDAO> userDAOList) {
        this.userDAOList = userDAOList;
    }

    public List<UserDAO> getUserDAOList() {
        return userDAOList;
    }

    public void setUserDAOList(List<UserDAO> userDAOList) {
        this.userDAOList = userDAOList;
    }
}
