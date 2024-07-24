package com.yk.spring.springboot.springboot_rest_api.controller;


import com.yk.spring.springboot.springboot_rest_api.entity.Employee;
import com.yk.spring.springboot.springboot_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

//    @PostMapping("/employees")
//    public Employee addNewEmployee(@RequestBody Employee employee) {
//
//        employeeService.saveEmployee(employee);
//
//        return employee;
//    }
//
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//
//        employeeService.saveEmployee(employee);
//        return employee;
//    }

}
