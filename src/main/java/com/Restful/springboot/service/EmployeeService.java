package com.Restful.springboot.service;

import com.Restful.springboot.model.Employee;
import com.Restful.springboot.service.impl.EmployeeServiceImpl;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee employee,Long id);

    void  deleteEmployee(Long id);



}
