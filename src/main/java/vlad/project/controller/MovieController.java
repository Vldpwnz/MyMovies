package vlad.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vlad.project.entities.Movie;
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
	
	@GetMapping("/new-movie")
	public String showNewMovieForm(Movie movie) {
		return "add-movie";
	}
	
	@PostMapping("/add-movie")
	public String addNewMovie(Movie movie, BindingResult result, Model model) {
		//processing errors while adding new movie
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			System.out.println("Movie is not added");
			return "add-movie";
		}
		movieService.save(movie);
		model.addAttribute("movie", movieService.findAll());
		return"redirect:/movies/all";
	}

}
