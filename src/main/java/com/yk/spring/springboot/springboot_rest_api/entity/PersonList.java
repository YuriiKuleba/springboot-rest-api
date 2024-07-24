package com.yk.spring.springboot.springboot_rest_api.entity;

import java.util.ArrayList;
import java.util.List;

public class PersonList {

    private List<Person> personList;

    public PersonList() {
    }

    public PersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void setPersonList(List<Person> personList) {
        if (personList == null) {
            personList = new ArrayList<>();
        }
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
