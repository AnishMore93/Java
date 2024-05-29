package com.Springboot.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Springboot.Employee.model.Employee;
import com.Springboot.Employee.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class DashboardController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employeelist")
	public String getStudentList(Model model) {
		List<Employee> employeeList=employeeService.employeeList();
		model.addAttribute("employees",employeeList);
		return "employees";
	}
	
	@PostMapping("/employee/delete")
    public String getDelete(@RequestParam("id") int id, Model model) {
        employeeService.deleteByID(id);
        String deleteMessage = "Employee Successfully Deleted With Id: " + id;
        model.addAttribute("message", deleteMessage);
        List<Employee> employeeList = employeeService.employeeList();
        model.addAttribute("employees", employeeList);
        return "employees";
    }
	
	@GetMapping("/employee/edit")
    public String getEdit(@RequestParam("id") int id, Model model) {
        System.out.println("check");
    	Employee employee = employeeService.findByID(id);
        System.out.println(employee.getName());
        model.addAttribute("employee", employee);
       
        return "updateform";  
    }
	
	@PostMapping("/saveupdate")
    public String getUpdate(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindResult) {
    	if(bindResult.hasErrors()) {
    		return "updateform";
    	}
    	employeeService.updateEmployee(employee);
		return "redirect:/employeelist";
    	
    }


}
