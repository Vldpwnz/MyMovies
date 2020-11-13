package vlad.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/account")
	public String getAccountPage(Authentication auth, Model model) {
		model.addAttribute("user", userService.findByUserName(auth.getName()));
		return "user-page";
	}
	
	
	
}
