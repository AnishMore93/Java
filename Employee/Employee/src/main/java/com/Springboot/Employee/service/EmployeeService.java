package com.Springboot.Employee.service;

import java.util.List;

import com.Springboot.Employee.model.Employee;


public interface EmployeeService {
	
public Employee saveRegistered(Employee employee);
	
	public List<Employee> employeeList();
	
	public void deleteByID(int id);
	
	public Employee findByID(int id);
	
	public Employee updateEmployee(Employee employee);

}
