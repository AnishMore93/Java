package com.Springboot.Employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Springboot.Employee.model.Employee;
import com.Springboot.Employee.service.EmployeeService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/registerEmployee")
	public String registerEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		return "employeeregisteration";
	}
	
	@PostMapping("/status")
	public String getStatus(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "employeeregisteration";
		}
		employeeService.saveRegistered(employee);
		return "redirect:/employeelogin";
		
	}

}
