package com.Springboot.StudentManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Springboot.StudentManagement.Model.Student;
import com.Springboot.StudentManagement.service.StudentService;

import jakarta.validation.Valid;

@Controller
@Transactional
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/registerStudent")
	public String registerStudent(Model model) {
		model.addAttribute("student",new Student());
		return "studentregisteration";
	}
	
	@PostMapping("/status")
	public String getStatus(@Valid @ModelAttribute("student") Student student,BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "studentregisteration";
		}
		studentService.saveRegistered(student);
		return "redirect:/studentlogin";
		
	}

}
