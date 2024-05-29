package com.Springboot.TaskManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Springboot.TaskManager.Service.TaskService;
import com.Springboot.TaskManager.model.Task;

import jakarta.validation.Valid;

@Controller
public class DashboardController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasklist")
	public String getStudentList(Model model) {
		List<Task> taskList=taskService.taskList();
		model.addAttribute("tasks",taskList);
		return "tasks";
	}
	@PostMapping("/task/delete")
    public String getDelete(@RequestParam("id") int id, Model model) {
        taskService.deleteByID(id);
        String deleteMessage = "Task Successfully Deleted With Id: " + id;
        model.addAttribute("message", deleteMessage);
        List<Task> taskList = taskService.taskList();
        model.addAttribute("tasks", taskList);
        return "tasks";
    }
	
	@GetMapping("/task/edit")
    public String getEdit(@RequestParam("id") int id, Model model) {
        System.out.println("check");
    	Task task = taskService.findByID(id);
        System.out.println(task.getTaskname());
        model.addAttribute("task", task);
       
        return "updateform";  
    }
	
	@PostMapping("/saveupdate")
    public String getUpdate(@Valid @ModelAttribute("task") Task task,BindingResult bindResult) {
    	if(bindResult.hasErrors()) {
    		return "updateform";
    	}
    	taskService.updateTask(task);
		return "redirect:/tasklist";
    	
    }
	
	 @GetMapping("/task/add")
	    public String showAddTaskForm(Model model) {
	        model.addAttribute("task", new Task());
	        return "addtask";
	    }

	    @PostMapping("/task/add")
	    public String addTask(@Valid @ModelAttribute("task") Task task, BindingResult bindResult) {
	        if (bindResult.hasErrors()) {
	            return "addtask";
	        }
	        taskService.saveTask(task);
	        return "redirect:/tasklist";
	    }

}
