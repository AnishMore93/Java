package com.Springboot.Employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.Employee.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
