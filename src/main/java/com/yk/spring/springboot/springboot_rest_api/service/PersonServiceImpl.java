package com.yk.spring.springboot.springboot_rest_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.yk.spring.springboot.springboot_rest_api.entity.Person;
import com.yk.spring.springboot.springboot_rest_api.entity.PersonList;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Override
    @Transactional
    public List<Person> readPersonsFromYaml(){

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        PersonList personList;

        try {
            personList = objectMapper.readValue(getClass().getResourceAsStream("/application.yaml")
                , PersonList.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return personList.getPersonList();
    }

}
