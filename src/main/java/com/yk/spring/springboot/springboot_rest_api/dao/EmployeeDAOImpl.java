package com.yk.spring.springboot.springboot_rest_api.dao;


import com.yk.spring.springboot.springboot_rest_api.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
//        Session session = entityManager.unwrap(Session.class);
////        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> employees = query.getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

//    @Override
//    public void saveEmployee(Employee employee) {
////        Session session = entityManager.unwrap(Session.class);
////        session.saveOrUpdate(employee);
//
//        Employee newEmployee = entityManager.merge(employee);
//        employee.setId(newEmployee.getId());
//    }

}
