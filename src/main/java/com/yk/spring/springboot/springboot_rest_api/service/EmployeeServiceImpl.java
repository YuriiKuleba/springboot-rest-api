package com.yk.spring.springboot.springboot_rest_api.service;


import com.yk.spring.springboot.springboot_rest_api.dao.EmployeeDAO;
import com.yk.spring.springboot.springboot_rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {return employeeDAO.getEmployee(id); }

//    @Override
//    @Transactional
//    public void saveEmployee(Employee employee) {
//        employeeDAO.saveEmployee(employee);

//    }

}
