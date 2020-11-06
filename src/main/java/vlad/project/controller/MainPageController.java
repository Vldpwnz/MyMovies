package vlad.project.controller;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainPageController {

	@GetMapping("/home-page")
	public String getMainPage(Authentication auth, Model model) {
		model.addAttribute("username", auth.getName());
		return "main-page";
	}
}
