package vlad.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vlad.project.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	private UserServiceImpl userService;

	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;	
	}
	
	
	@GetMapping("/all")
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user-list";
		
	}
}
