package com.yk.spring.springboot.springboot_rest_api.service;


import com.yk.spring.springboot.springboot_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployee(int id);

//    void saveEmployee(Employee employee);

}
