package com.Restful.springboot.repository;

import com.Restful.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {


}