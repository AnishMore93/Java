package com.Springboot.StudentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Springboot.StudentManagement.Model.Student;
import com.Springboot.StudentManagement.Model.StudentHome;
import com.Springboot.StudentManagement.service.StudentService;

import jakarta.validation.Valid;

@Controller
@Transactional
public class LoginController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/studentlogin")
	public String getLogin(Model model) {
		model.addAttribute("studenthome",new StudentHome());
		return "studenthome";
	}
	@PostMapping("/studentloginstatus")
	public String getlogstatus(@Valid @ModelAttribute("studenthome") StudentHome studenthome, BindingResult bindResult,Model model) {
		if(bindResult.hasErrors()) {
			return "studenthome";
		}
		
		List<Student> dbstudentList = studentService.studentList();
		boolean found = false;
		
		for (Student dbv : dbstudentList) {
			if(dbv.getUsername().equals(studenthome.getUsername())&&dbv.getPassword().equals(studenthome.getPassword())) {
				found=true;
            }
		}
		if(found) {
			return "studentdashboard";
		}
		else {
			model.addAttribute("error","Incorrect username or password");
			return "studenthome";
		}
	}
	
	

}
