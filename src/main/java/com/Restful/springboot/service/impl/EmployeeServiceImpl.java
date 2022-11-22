package com.Restful.springboot.service.impl;

import com.Restful.springboot.exception.ResourceNotFoundException;
import com.Restful.springboot.model.Employee;
import com.Restful.springboot.repository.EmployeeRepository;
import com.Restful.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee =employeeRepository.findById(id);

        if (employee.isPresent()){
            return employee.get();
        }else {
            throw new ResourceNotFoundException("Employee","id",id);
        }

    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        //we need to check whether employee with given id is exist in DB or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()  -> new ResourceNotFoundException("Employee","id",id)
        );

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        //save existing employee to DB
        employeeRepository.save(existingEmployee);


        return existingEmployee ;


    }

    @Override
    public void deleteEmployee(Long id) {
        //we need to check whether employee exist in DB or not
        employeeRepository.findById(id).orElseThrow(()  ->
                                new ResourceNotFoundException("Employee","id",id)) ;

        employeeRepository.deleteById(id);


    }


}
