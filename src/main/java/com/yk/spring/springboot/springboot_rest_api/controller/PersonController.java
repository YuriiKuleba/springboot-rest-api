package com.yk.spring.springboot.springboot_rest_api.controller;

import com.yk.spring.springboot.springboot_rest_api.entity.Person;
import com.yk.spring.springboot.springboot_rest_api.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personService.readPersonsFromYaml();
    }
}
