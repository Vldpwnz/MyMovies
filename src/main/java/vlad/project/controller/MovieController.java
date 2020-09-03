package vlad.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vlad.project.service.MovieServiceImpl;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
	private MovieServiceImpl movieService;
	
	@Autowired
	public MovieController(MovieServiceImpl movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/all")
	public String getAllMovies(Model model) {
		model.addAttribute("movies", movieService.findAll());
		return "movies-list";
	}

}
