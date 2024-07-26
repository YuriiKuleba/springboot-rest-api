package com.yk.spring.springboot.springboot_rest_api.dao;

import com.yk.spring.springboot.springboot_rest_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
