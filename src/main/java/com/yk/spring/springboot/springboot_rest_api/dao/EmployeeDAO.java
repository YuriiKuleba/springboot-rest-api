package com.yk.spring.springboot.springboot_rest_api.dao;

import com.yk.spring.springboot.springboot_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getEmployees();

    Employee getEmployee(int id);

//    void saveEmployee(Employee employee);

}
