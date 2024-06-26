package com.Springboot.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Springboot.Employee.model.Employee;
import com.Springboot.Employee.model.EmployeeHome;
import com.Springboot.Employee.service.EmployeeService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class LoginController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employeelogin")
	public String getLogin(Model model) {
		model.addAttribute("employeehome",new EmployeeHome());
		return "employeehome";
	}
	@PostMapping("/employeeloginstatus")
	public String getlogstatus(@Valid @ModelAttribute("employeehome") EmployeeHome employeehome, BindingResult bindResult,Model model) {
		if(bindResult.hasErrors()) {
			return "employeehome";
		}
		
		List<Employee> dbemployeeList = employeeService.employeeList();
		boolean found = false;
		
		for (Employee dbv : dbemployeeList) {
			if(dbv.getUsername().equals(employeehome.getUsername())&&dbv.getPassword().equals(employeehome.getPassword())) {
				found=true;
            }
		}
		if(found) {
			return "employeedashboard";
		}
		else {
			model.addAttribute("error","Incorrect username or password");
			return "employeehome";
		}
	}
	

}
