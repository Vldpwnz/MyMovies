package vlad.project.restcontrollers;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MainController {
	
	@GetMapping("/rest/hello")
	public String hello() {
		
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth = context.getAuthentication();
		
		return "Hello " + auth.getName() + "! ";
	}
	
	

}
