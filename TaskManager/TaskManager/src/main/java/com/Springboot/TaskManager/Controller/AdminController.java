package com.Springboot.TaskManager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Springboot.TaskManager.Service.AdminService;
import com.Springboot.TaskManager.model.TaskAdmin;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/registertaskadmin")
	public String registerAdmin(Model model) {
		model.addAttribute("taskadmin",new TaskAdmin());
		return "taskadminregisteration";
	}
	
	@PostMapping("/status")
	public String getStatus(@Valid @ModelAttribute("taskadmin") TaskAdmin taskadmin,BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "taskadminregisteration";
		}
		adminService.saveAdmin(taskadmin);
		return "redirect:/taskadminlogin";
		
	}

}
