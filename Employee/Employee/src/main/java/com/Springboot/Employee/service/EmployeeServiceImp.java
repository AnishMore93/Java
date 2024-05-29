package com.Springboot.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Employee.dao.EmployeeRepo;
import com.Springboot.Employee.model.Employee;
@Service
public class EmployeeServiceImp implements EmployeeService{
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee saveRegistered(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> employeeList() {
		// TODO Auto-generated method stub
		List<Employee> findAll= employeeRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteByID(int id) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee findByID(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> findById= employeeRepo.findById(id);
		Employee employee=findById.get();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

}
