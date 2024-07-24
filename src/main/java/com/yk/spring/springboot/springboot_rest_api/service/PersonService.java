package com.yk.spring.springboot.springboot_rest_api.service;

import com.yk.spring.springboot.springboot_rest_api.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> readPersonsFromYaml();
}
