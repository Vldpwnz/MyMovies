package vlad.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vlad.project.Entities.Movie;
import vlad.project.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	private final MovieRepository repository;
	
	@Autowired
	public MovieServiceImpl(MovieRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}
	
	

	
}
