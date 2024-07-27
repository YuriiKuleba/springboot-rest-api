package com.yk.spring.springboot.springboot_rest_api.service;

import com.yk.spring.springboot.springboot_rest_api.entity.User;
import com.yk.spring.springboot.springboot_rest_api.exception.NoSuchUserException;
import com.yk.spring.springboot.springboot_rest_api.provider.JpaRepoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JpaRepoProvider jpaRepoProvider;

    @Override
    @Transactional
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        List<SimpleJpaRepository<User, Integer>> repositories = jpaRepoProvider.getRepositories();

        for (SimpleJpaRepository repo : repositories) {
            List<User> allUsers = repo.findAll();
            users.addAll(allUsers);
        }
        return users;
    }

    @Override
    @Transactional
    public List<User> getUserById(int id) {
        List<User> usersList = new ArrayList<>();
        List<SimpleJpaRepository<User, Integer>> repositories = jpaRepoProvider.getRepositories();

        for (SimpleJpaRepository<User, Integer> repo : repositories) {
            Optional<User> user = repo.findById(id);
            usersList.add(user.orElseThrow( () -> new NoSuchUserException("There is no employee with id = " + id + " in Database")));
        }
        return usersList;
    }
}
