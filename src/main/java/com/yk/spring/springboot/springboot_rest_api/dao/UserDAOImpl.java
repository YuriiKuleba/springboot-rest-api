package com.yk.spring.springboot.springboot_rest_api.dao;

import com.yk.spring.springboot.springboot_rest_api.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = entityManager.find(User.class, id);

        return user;
    }
}
